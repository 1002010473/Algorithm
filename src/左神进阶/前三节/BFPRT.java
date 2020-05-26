package 左神进阶.前三节;

import com.sun.beans.finder.BeanInfoFinder;

/**
 * @description:求数组中第k小的元素
 * @author: 文琛
 * @time: 2020/5/21 21:03
 */
public class BFPRT {
    public static void main(String[] args) {
        int[] arr = {1,6,3,7,4};
        System.out.println(getMinKthByBFPRT(arr,2));
    }
    public static int getMinKthByBFPRT(int[] arr, int k){
        //第k小 == k-1 位置上的元素
        return bfprt(arr, 0, arr.length-1, k -1);
    }

    private static int bfprt(int[] arr, int begin, int end, int targetInd) {
        if(begin == end)
            return arr[begin];
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if( targetInd >= pivotRange[0] && targetInd <= pivotRange[1]){
            return arr[targetInd];
        }else if ( targetInd < pivotRange[0]){
            return bfprt(arr, begin, pivotRange[0] - 1, targetInd);
        }else{
            return bfprt(arr, pivotRange[1] + 1, end, targetInd);
        }
    }

    private static int[] partition(int[] arr, int begin, int end, int pivot) {
        int smaller = begin -1;
        int cur = begin;
        int bigger = end + 1;
        while(cur != bigger){
            if(arr[cur] == pivot){
                cur++;
            }else if (arr[cur] > pivot){
                swap(arr, cur, --bigger);
            }else{
                swap(arr, cur++, ++smaller);
            }
        }
        return new int[]{smaller+1, bigger-1};
    }

    private static int medianOfMedians(int[] arr, int begin, int end) {
        //求中位数集合的中位数
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num/5 + offset];
        for(int i = 0; i < mArr.length; i++){
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return bfprt(mArr, 0, mArr.length-1, mArr.length/2);
    }

    private static int getMedian(int[] arr, int begin, int end) {
        //插入排序
        insertSortion(arr, begin, end);
        int sum = begin + end;
        int mid = sum / 2 + sum % 2;
        return arr[mid];

    }

    private static void insertSortion(int[] arr, int begin, int end) {
        for(int i = begin + 1; i != end+1; i++){
            for(int j = i ; j != begin; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j-1, j);
                }else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
