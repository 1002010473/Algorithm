package Algorithm.data_struct.stack.单调stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/22 21:02
 */
public class lc581_最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        //单调栈 -- 寻找无序的边界
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int left = len;
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && nums[stack.peekLast()] > nums[i]){
                stack.removeLast();
            }
            if(stack.isEmpty()){
                if(i != 0){
                    left = 0;
                    break;
                }
            }else{
                if(stack.peekLast() != i - 1){
                    left = Math.min(left, stack.peekLast() + 1);
                }
            }
            stack.addLast(i);
        }
        if(left == len) return 0;
        stack.clear();
        int right = -1;
        for(int i = len - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[i]){
                stack.removeLast();
            }
            if(stack.isEmpty()){
                if(i != len - 1){
                    right = len - 1;
                    break;
                }
            }else{
                if(stack.peekLast() != i + 1){
                    right = Math.max(right, stack.peekLast() - 1);
                }
            }
            stack.addLast(i);
        }
        return right - left + 1;
    }
}
