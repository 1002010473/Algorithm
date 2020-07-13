package Algorithm.二分查找.rotated;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/13 21:57
 */
public class lc81_旋转排序重复数组的搜索 {
    //
    public boolean search(int[] nums, int target) {
        //延续33 和 154 的思路
        int len = nums.length;
        if(len == 0)
            return false;
        int index = method(nums);
        int min = nums[index];
        if(min == nums[0] && min == nums[len-1]){ // 特判 针对 111111121111111这种情况，也只有这种情况下，index会选在最大值的前面，出现在峰值数组上进行二分的请况，不能满足要求
            for(int i = len - 1; i >= 0; i--){
                if(nums[i]!=min){
                    index = i + 1;
                    break;
                }
            }
        }
        return is(nums,target, 0, Math.max(0, index - 1)) || is(nums,target, index, len -1);
    }
    public int method(int[] nums){
        int len = nums.length;
        int left = 0, right = len -1;
        while(left < right){
            int mid = left + ((right - left) >>> 1);
            int num = nums[mid];
            if(num < nums[right]){
                right = mid;
            }else if(num > nums[right]){
                left  = mid + 1;
            }else{
                right--;
            }
        }
        return left;
    }
    public boolean is(int[] nums, int target, int left, int right){
        while(left <= right){
            int mid = left + ((right - left) >>> 1);
            int num = nums[mid];
            if(num < target){
                left = mid + 1;
            }else if(num > target){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
