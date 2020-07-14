package Algorithm.binary_search;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/14 9:40
 */
public class lc35_无重复数组的插入位置 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len==0)
            return 0;
        int left = 0;
        int right = len-1;
        while(left <= right){
            int mid =left + ((right - left) >>> 1);
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
