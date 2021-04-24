package Algorithm.twopointers.seq.target;

import java.util.Arrays;

/**
 * @description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * @author: 文琛
 * @time: 2020/6/25 14:01
 */
public class lc16_最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,4};
        System.out.println(threeSumClosest(nums, 1));
    }
    //按照上题的双指针继续尝试
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDis = Math.abs(target - res);
        for(int i = 0; i < nums.length; i++){
            int head = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int n = head + nums[left] + nums[right];
                int distance = Math.abs(target - n);
                if(n == target){
                    return n;
                }else if ( n < target){
                    left++;
                }else{
                    right--;
                }
                if(distance < minDis){
                    res = n;
                    minDis = distance;
                }
            }
        }
        return res;
    }
}
