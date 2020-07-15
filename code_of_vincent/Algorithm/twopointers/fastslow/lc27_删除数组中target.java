package Algorithm.twopointers.fastslow;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/15 14:37
 */
public class lc27_删除数组中target {
    public int removeElement(int[] nums, int val) {
        //快慢指针么
        int slow = 0, quick = 0;
        int len = nums.length;
        while(quick < len){
            if(nums[quick] != val){
                nums[slow++] = nums[quick];
            }
            quick++;
        }
        return slow;
    }
}
