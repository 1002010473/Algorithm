package Algorithm.binary_search.gFunction;

/**
 * @description: 在并不有序的数组上进行二分
 * @author: 文琛
 * @time: 2020/7/12 9:54
 */
public class lc162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        //二分查找适用于有序，给定的nums是阶段性的递增或递减(没有相邻的相同元素)
        //参考相关题解：见readme -- 排除的思想
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + ((right - left) >>> 1); // 此处括号必不可少
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1; //将mid作为新的左边界对应的负无穷
            }else{
                right = mid; //将mid+1作为新的右边界对应的负无穷
            }
        }
        return left;
    }
}
