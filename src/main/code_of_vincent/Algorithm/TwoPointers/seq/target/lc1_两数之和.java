package Algorithm.twopointers.seq.target;

import java.util.Arrays;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/15 10:52
 */
public class lc1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        Arrays.sort(nums); // 时间复杂度 nlogn
        while(left < right){
            int n = nums[left] + nums[right];
            if(n == target){
                return new int[]{left, right};
            }else if (n < target){
                left++;
            }else {
                right--;
            }
        }
        return new int[0];
    }
}
