package Algorithm.sort;
/**
 * @description: 基于大根堆进行排序
 *
 * 时间复杂度：分为两部分--1.初始化堆  O(n)   2.重建堆  O(nlogn)
 * 空间复杂度：就地排序 O1；
 *
 * 数组元素从0开始计数
 * 父节点n 左子节点2n+1 右子节点2n+2
 *
 * 大根堆： 将元素添加到数组末尾，如果大于父节点，进行上浮操作，将根节点和末尾节点进行交换，并进行根节点的下沉操作
 *
 * @author: 文琛
 * @time: 2019/12/24 15:27
 */
public class Heap {
    public static void main(String[] args) {
        //int[] array = {0,2,5,8,4,1,7};
        int[] array = {3,2,5,8,4,1,7};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void sort(int[] array) {
        if(array==null || array.length<2) return;
        int N = array.length-1;
        for (int k = 0;k<=N;k++){ // 对k节点进行插入，即进行初始化
            heapInsert(array,k); //
        }
        //将最大值跟最后面的值交换，最大值不需要进行变动，但堆的大小需要减1
        int size = array.length;
        while(size>1){
            exch(array,0,--size);
            heapify(array,0,size);
        }
    }

    private static void exch(int[] array, int i, int N) {
        int temp = array[i];
        array[i] = array[N];
        array[N] = temp;
        /*System.out.println(temp);*/
    }

    //上浮方法，将元素添加到堆的底部，然后进行上浮，实现初始化
    public static void heapInsert(int[] array, int k) {
        while(array[k]>array[(k-1)/2]){
            exch(array,k,(k-1)/2);
            k = (k-1)/2;
        }
    }
    //下沉方法，将变小后的元素进行下沉操作，和子节点中最大的那个进行交换
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index*2+1;
        while(left<heapSize){
            int largest = left+1<heapSize && arr[left+1]>arr[left]?left+1:left;
            largest = arr[index]>arr[largest]?index:largest;
            if(largest == index) break;
            exch(arr,index,largest);
            index = largest;
            left = index*2+1;
        }
    }

}
