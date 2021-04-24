package Algorithm.twopointers;

/**
 * @description: 给定一个正整数数组 nums。
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * tips：正整数（连续子数组）---双指针/滑动窗口
 * @author: 文琛
 * @time: 2020/6/25 14:47
 * jing
 */
public class lc713_乘积小于k的子数组 {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
    //窗口：下面解法的改进板
    //
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //k >= 0
        if(k == 0)
            return 0;
        int res = 0;
        int tmp = 1;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            tmp *= nums[r];
            while(tmp >= k){
                tmp /= nums[l++];
            }
            //此处，加上的是以r作为右边界的子数组的所有个数（必须连续到r）
            res += (r - l + 1);
        }
        return res;
    }

    //n方遍历
    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        //k >= 0
        if(k == 0)
            return 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int r = i;
            int count = 1;
            while(r < nums.length && count < k){
                count *= nums[r++];
                if(count < k)
                    res++;
            }
        }
        return res;
    }
}
