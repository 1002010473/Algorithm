package Algorithm.dac;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/14 11:03
 */
public class lc912_MergeSort {
    //自顶向下的递归排序
    static int[] arr;
    public static void sort_TopToBottom(int[] array) {
        int len = array.length;
        arr = new int[len];
        sort(array,0,len-1);
    }
    //递归主体
    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi)  return;
        int mid = lo + ((hi-lo) >> 1);
        //左右排序+merge
        //其实全部的排序实现都在merge方法上
        sort(array,lo,mid);
        sort(array,mid+1,hi);
        merge(array,lo,mid,hi);
    }
    //归并
    public static void merge(int[] array, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++){ //将arr作为原始数据进行merge排序
            arr[k] = array[k];
        }
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                array[k] = arr[j++];
            }else if (j > hi){
                array[k] = arr[i++];
            }else if (arr[j] < arr[i]){
                array[k] = arr[j++];
            }else{
                array[k] = arr[i++]; //二者相等时，合并的是左边的--稳定
            }
        }
    }

    //自底向上的排序 -- 非递归  lc验证可行
    private static void sort_BottomToTop(int[] array) {
        int len = array.length;
        arr = new int[len];
        int i = 1;
        while (i < len){
            for (int j = 0;j + i <= len; j += (2*i)){
                merge(array,j,j+i-1,Math.min(j+i+i-1,len-1));
            }
            i=2*i;
        }
    }
}
