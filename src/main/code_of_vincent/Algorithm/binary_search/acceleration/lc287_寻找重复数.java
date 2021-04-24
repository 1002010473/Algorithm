package Algorithm.binary_search.acceleration;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/12 10:54
 */
public class lc287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;
        while(left < right){
            int mid = left + ((right - left) >>> 1);
            int count = method(nums,left, mid);
            if(count > (mid - left + 1)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public int method(int[] nums, int left, int right){
        int count = 0;
        for(int num : nums){
            if(num <= right && num >= left)
                count++;
        }
        return count;
    }
}
