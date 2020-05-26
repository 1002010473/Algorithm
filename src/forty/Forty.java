package forty;

import Other.Sort.Heap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:寻找n个数字中最小的k个数字
 *     最简单思路：排序后挑选--nlog(n)
 *     第一种方法：基于partition 基于数组调整后，第k个数字左边的都小于该数字，右边的都大于该数字。----该方法会修改输入的数组
 *     第二种方法：二叉树实现log（n）复杂度的增改查，使用堆的思想，一个大小为k的最大堆--O(1）得到已有的k个数字中的最大值，但需要O(logk)时间完成删除及插入操作。
 *               该方法中，采用数组中从0开始的计算方法--父节点n 左子节点2n+1 右子节点2n+2
 * @author: 文琛
 * @time: 2020/2/4 8:58
 */
public class Forty {
    public static void main(String[] args) {
        Forty test = new Forty();
        int[] arr = {3,5,2,6,1,7};
        int k =3;
        List result = test.partition(arr,k);
        System.out.println(result);
    }
    @Test
    public void method2(){
        Forty test = new Forty();
        int[] array = {3,5,2,6,1,7};
        int k1 =4   ;
        int[] result2 = heapFind(array,k1);
        for (int i : result2) {
            System.out.print(i+" ");
        }

    }

    private int[] heapFind(int[] array, int k1) {
        if (array==null||array.length==0||array.length<k1) return null;

        int[] Maxheap = new int[k1];

        for (int i = 0; i<k1;i++){
            Maxheap[i] = array[i];
        }
        initMaxHeap(Maxheap,k1-1);
        for (int j = k1;j<array.length;j++){
            if (Maxheap[0]>array[j]){
                reloadHeap(Maxheap,array[j]);
            }
        }


        return Maxheap;
    }

    private void reloadHeap(int[] maxheap, int i) {
        maxheap[0] = i;
        sink(maxheap,0,maxheap.length-1);
    }

    private void initMaxHeap(int[] maxheap, int i) {
        for (int k = i/2;k>=0;k--){ //确定开始初始化的父节点
            sink(maxheap,k,i);
        }
    }

    private void sink(int[] array, int k, int i) {
        while (2*k+1<=i){
            int j = 2*k+1;
            if ( j < i&& array[j]<array[j+1]) j++; //判断左右子节点的大小
            if (array[k]>array[j]) break; //如果父节点大于子节点，break；
            int temp = array[k];
            array[k] = array[j];
            array[j] = temp;
            k = j;//循环的意义在于将父节点和子节点交换后需要对变更后的节点进行重新比较 ，即将子节点作为父节点比较。
        }
    }

    /*1.将数组和k传给函数
* 2.获取数组首数字的index；
* 3.比较index和k：如果相等，进行列表的输出，不相等，则进行low和high的变更----low和high逐渐缩小，直至等于 k；
* */
    private List partition(int[] arr, int k) {
        if (arr == null || arr.length ==0) return null;
        List<Integer> list = new ArrayList<>();
        int low = 0;
        int high = arr.length-1;
        int index = partition(arr,low,high);
        while (index !=k ){
            if (index < k){
                low = index + 1;
                index = partition(arr,low,high);
            }else if( index > k ){
                high = index -1;
                index = partition(arr,low,high);
            }
        }
        for (int i = 0;i<k;i++){
            list.add(arr[i]);
        }
        return list;
    }

    private int partition(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high){
            while (arr[high]>=temp && low < high){
                high--;
            }
            if (low<high){
                arr[low] = arr[high];
                low++;
            }
            while (arr[low]<=temp && low<high){
                low++;
            }
            if (low<high){
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = temp;

        return low;
    }
}
