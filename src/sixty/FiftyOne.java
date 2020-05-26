package sixty;

import org.junit.Test;
import sun.security.util.Length;

/**
 * @description: 数组中的逆序对
 * test1--自做暴力解法--O(n2) 超时
 * test2--归并排序的改进--O(n log n)
 * @author: 文琛
 * @time: 2020/2/13 14:09
 */
public class FiftyOne {
    @Test
    public void test1(){
        int [] arr = {7,5,6,4};
        int i = reversePairs(arr);
        System.out.println(i);
    }
    public int reversePairs(int[] nums) {
        int length = nums.length;
        int result = 0;
        for(int i = 0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]>nums[j]){
                    result++;
                }
            }
        }
        return result;
    }
    @Test
    public void test2(){
        int [] arr = {7,5,6,4};
        int i = reversePairs_(arr);
        System.out.println(i);
    }

    private int reversePairs_(int[] arr) {
        if (arr==null||arr.length<=0){
            return 0;
        }
        int length = arr.length;
        int[] copy = new int[length];
        for (int i=0;i<length;i++){
            copy[i]=arr[i];
        }
        int count = depart(arr,copy,0,length-1);
        return count;
    }

    private int depart(int[] arr, int[] copy, int start, int end) {
        if (start==end){
            copy[start]=arr[start];
            return 0;
        }
        int mid = start+(end-start)/2;
        int left= depart(copy,arr,start,mid);
        int right = depart(copy,arr,mid+1,end);
        int i = mid;//i初始化为前半段最后一个数字的下标；
        int j = end;//j初始化为后半段最后一个数字的下标；
        //归并
        int indexCopy = end;
        int count = 0;

        while(i>=start&&j>mid){
            if (arr[i]>arr[j]){
                copy[indexCopy--]=arr[i--];
                count += j-mid;
            }else {
                copy[indexCopy--] =arr[j--];
            }
        };
        for (;i>=start;i--){
            copy[indexCopy--] = arr[i];
        }
        for (;j>=mid+1;j--){
            copy[indexCopy--] = arr[j];
        }
        return left+right+count;
    }
}
