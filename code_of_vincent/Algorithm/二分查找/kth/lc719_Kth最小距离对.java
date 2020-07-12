package Algorithm.二分查找.kth;

import java.util.Arrays;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/12 19:40
 */
public class lc719_Kth最小距离对 {
    public int smallestDistancePair(int[] nums, int k) {
        //延续668思路：尝试将二维的查找转换为一遍过的一维信息
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0, right = nums[len-1] - nums[0];
        while(left <= right){
            int mid = left + ((right - left) >>> 1);
            int count = method(nums, mid);
            if(count < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public int method(int[] nums, int mid){ // 返回绝对插值小于等于mid的个数
        //由于是有序数组差值的绝对值，所以只需要查找一半即可
        //从右往左保持 相等 或 递增
        int len = nums.length;
        int heightIndex = len - 1;
        int res = 0;
        for(int i = len - 2; i >= 0; i--){
            while(heightIndex > i && nums[heightIndex] - nums[i] > mid){
                heightIndex--;
            }
            res += (heightIndex - i);
        }
        return res;
    }
}
