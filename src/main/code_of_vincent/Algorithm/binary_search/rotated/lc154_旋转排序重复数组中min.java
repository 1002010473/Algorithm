package Algorithm.binary_search.rotated;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/13 20:43
 */
public class lc154_旋转排序重复数组中min {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            int tm = nums[mid];
            if(tm < nums[right]){
                right = mid;
            }else if (tm > nums[right]){
                left = mid + 1;
            }else{
                right --; //证明见题解
            }
        }
        return nums[left];
    }
}
