package Algorithm.data_struct.stack.单调stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/22 21:02
 */
public class lc581_最短无序连续子数组 {
    //单调栈 -- 寻找边界
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length, left = len, right = 0;
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && nums[stack.peekLast()] > nums[i]){
                left = Math.min(left, stack.removeLast());
            }
            stack.addLast(i);
        }
        stack.clear(); // 此处如果重新new一个新的list，时间复杂度从 9 到 13
        for(int i = len - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[i]){
                right = Math.max(right, stack.removeLast());
            }
            stack.addLast(i);
        }
        return right > left ? right - left + 1 : 0;
    }
}
