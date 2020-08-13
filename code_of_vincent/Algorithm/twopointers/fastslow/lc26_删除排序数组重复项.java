package Algorithm.twopointers.fastslow;

public class lc26_删除排序数组重复项 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        int index = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] != nums[index - 1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
