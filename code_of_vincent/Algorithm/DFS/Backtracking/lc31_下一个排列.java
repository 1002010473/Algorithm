package Algorithm.DFS.Backtracking;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/11 11:35
 */
public class lc31_下一个排列 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) { //如果是递减的排列，那么没有更大的组合，只需要reverse即可
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) { //再遍历一遍，找最小的更大值,由于是降序，所以顺序遍历即可
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);//从i+1开始，必然是递减的状态，即便swap，替换的也是一个合适的顺序，只需要reverse
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
