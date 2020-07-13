package Algorithm.二分查找.rotated;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/13 21:01
 */
public class lc153_旋转排序数组中min {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            int tmp = nums[mid];
            if(tmp < nums[right]){ // 为什么比较right
                right = mid;
            }else{
                left = mid + 1; //为什么在 == 时 mid + 1，详情见题解
            }
        }
        return nums[left];
    }
}
