package sixty;

import org.junit.Test;

/**
 * @description:
 * 1 暴力解法：O（n)
 * 2. 二分查找法：O(n)
 * @author: 文琛
 * @time: 2020/2/13 18:52
 */
public class FiftyThree_1 {
    @Test
    public void test1(){
        int[] arr = {1,2,3,3,3,4,5,6};
        int search = search(arr, 3);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==target){
                result++;
                continue;
            }
            if(nums[i]>target) break;
        }
        return result;
    }
    @Test
    public void test2(){
        int[] arr = {1,2,3,3,3,4,5,6};
        int search = search_1(arr, 3);
        System.out.println(search);
    }

    private int search_1(int[] arr, int i) {
        if (arr==null||arr.length==0) return 0;
        int firstIndex=getFirst(arr,i,0,arr.length-1);
        int lastIndex = getLast(arr,i,0,arr.length-1);
        int result = 0;
        if (firstIndex>-1&&lastIndex>-1){
            result = lastIndex-firstIndex+1;
        }
        return result;
    }

    private int getLast(int[] arr, int i, int start, int end) {
        if (start>end) return -1;//判定没有最后出现的index
        int middleIndex = (start+end)/2;
        if (arr[middleIndex]==i){
            if (middleIndex<arr.length-1&&arr[middleIndex+1]!=i||middleIndex==arr.length-1){
                return middleIndex;//或两边 代表了两种情况--1.后半部分的第一位不等于i，2.后半部分没有了
            }else{
                start=middleIndex+1;
            }
        }else if (arr[middleIndex]>i){
            end = middleIndex-1;
        }else {
            start = middleIndex+1;
        }
        return getLast(arr,i,start,end);
    }

    private int getFirst(int[] arr, int i, int start, int end) {
        if (start>end) return -1;//判定没有第一次出现的index
        int middleIndex = (start+end)/2;
        if (arr[middleIndex]==i){
            if (middleIndex>0 && arr[middleIndex-1]!=i||middleIndex==0){//或两边 代表了两种情况--1.前半部分的最后一位不等于i，2.前半部分没有了
                return middleIndex;
            }else{
                end=middleIndex-1;
            }
        }else if (arr[middleIndex]>i){
            end = middleIndex-1;
        }else {
            start = middleIndex+1;
        }
        return getFirst(arr,i,start,end);
    }
}
