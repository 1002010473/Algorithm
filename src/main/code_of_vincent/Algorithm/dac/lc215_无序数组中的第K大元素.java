package Algorithm.dac;

/**
 * @description: 借助partation()实现
 * @author: 文琛
 * @time: 2020/7/14 19:04
 */
public class lc215_无序数组中的第K大元素 {
    public int findKthLargest(int[] nums, int k) {
        //尝试使用partation()进行分治的解法
        int left = 0, right = nums.length - 1;
        int target = nums.length - k;
        while(left < right){
            int index = partation(nums, left, right);
            if(index == target){
                return nums[index];
            }else if(index > target){
                right = index - 1;
            }else{
                left = index + 1;
            }
        }
        return nums[left]; // 针对nums.length == 1 的情况，跳过了循环，直接来到了return
    }
    public int partation(int[] nums, int left, int right){
        int comp = nums[left];
        int bound = left;
        for(int i = left + 1; i <= right; i++){
            if(nums[i] < comp){
                bound++;
                exchange(nums, i, bound);
            }
        }
        exchange(nums, left, bound);
        return bound;
    }
    public void exchange(int[] array, int i, int min) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }
}
