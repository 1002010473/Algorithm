package Algorithm.twopointers;

/**
 * @description: 荷兰国旗问题的简易版
 * @author: 文琛
 * @time: 2020/6/25 19:23
 */
public class lc75_颜色分类 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int n : nums){
            System.out.println(n);
        }
    }
    public static void sortColors(int[] nums) {
        //0, 1, 2 只有这三种元素
        //划分四个区域： 0，1，未整理，2
        int less = 0;
        int more = nums.length-1;
        int index = 0;
        while(index <= more){
            if(nums[index] == 0){
                swap(nums, index++, less++);
            }else if(nums[index] == 1){
                index++;
            }else{
                swap(nums, index, more--);
            }
        }
    }

    private static void swap(int[] nums, int index, int less) {
        int tmp = nums[index];
        nums[index] = nums[less];
        nums[less] = tmp;
    }
}
