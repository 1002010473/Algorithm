package Algorithm.TwoPointers;

public class lc26_刪除排序數組重復項 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length < 1)
            return 0;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] != nums[left]){
                nums[++left] = nums[right];
            }
            right++;
        }
        return left+1;
    }
}
