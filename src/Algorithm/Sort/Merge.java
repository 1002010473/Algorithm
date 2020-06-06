package Algorithm.Sort;

import org.junit.Test;

/**
 * @description:归并排序  --  分治思想 -- 从下而上
 * 自顶向下的归并 -- 递归
 * 时间复杂度  n log n
 * 空间复杂度  一个辅助的数组来临时存储  n
 * 自底向上的归并 --
 *
 * --逆序对问题见leetcode中实现
 *
 * @author: 文琛
 * @time: 2019/12/19 8:52
 */
public class Merge {
    private static int[] aux;
    public static void main(String[] args) {
        int[] array = {5,1,3,8,7,3};
        sort_TopToBottom(array);
        for (int num:array){
            System.out.println(num);
        }
    }
    @Test
    public void test(){
        int[] array = {5,1,3,8,7,3};
        sort_BottomToTop(array);
        for (int num:array){
            System.out.println(num);
        }
    }
    //自底向上的排序 -- 非递归
    private static void sort_BottomToTop(int[] array) {
        int N = array.length;
        aux = new int[N];
        int i = 1;
        while (i<N){
            for (int j = 0;j<N-i;j+=(2*i)){
                merge(array,j,j+i-1,Math.min(j+i+i-1,N-1));
            }
            i=2*i;
        }
    }

    //自顶向下的递归排序
    private static void sort_TopToBottom(int[] array) {
        int N = array.length;
        aux = new int[N];
        sort(array,0,N-1);
    }

    private static void sort(int[] array, int lo, int hi) {
        if (lo>=hi) return;
        int mid = lo + ((hi-lo)>>1);
        //逻辑很简单--左右排序+merge
        //其实全部的排序实现都在merge方法上
        sort(array,lo,mid);
        sort(array,mid+1,hi);
        merge(array,lo,mid,hi);

    }
    //归并 利用额外的数组 aux----将aux作为原始数据原来进行重新排序merge
    private static void merge(int[] array, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k=lo;k<=hi;k++){
            aux[k] = array[k];
        }
        for (int k = lo; k<=hi; k++){
            if (i>mid){
                array[k] = aux[j++];
            }else if (j>hi){
                array[k] = aux[i++];
            }else if (aux[j]<aux[i]){
                array[k] = aux[j++];
            }else{
                //二者相等时，合并的是左边的--稳定
                array[k] = aux[i++];
            }
        }
    }

}
