package Algorithm.twopointers;

import java.util.Arrays;

/**
 * @description: 给定一个n个整数的数组和一个目标整数target，
 * 找到下标为i、j、k的数组元素0 <= i < j < k < n，满足条件nums[i] + nums[j] + nums[k] < target.
 *
 * 找到比给定target要小的三个元素的所有可能性的个数
 * @author: 文琛
 * @time: 2020/6/25 14:18
 */
public class lic918_3SumSmaller {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        System.out.println(threeSumSmaller(nums, 2));
    }
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        // do   as previous sloutin
        for(int i = 0; i < nums.length; i++){
            int head = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int n = head + nums[left] + nums[right];
                if (n < target){
                    res += (right - left);
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;

    }
}
