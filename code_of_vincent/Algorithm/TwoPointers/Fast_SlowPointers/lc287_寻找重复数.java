package Algorithm.TwoPointers.Fast_SlowPointers;

/**
 * @description: 转换为寻找环形链表的入口节点
 * @author: 文琛
 * @time: 2020/6/28 15:59
 */
public class lc287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int quick = 0;
        int slow = 0;
        while(slow == 0 || quick != slow){
            slow = nums[slow];
            quick = nums[nums[quick]];
        }
        quick = 0;
        while(slow != quick){
            slow = nums[slow];
            quick = nums[quick];
        }
        return slow;
    }
}
