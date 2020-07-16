package Algorithm.stack.单调stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/16 10:49
 */
public class lc42_接雨水 {
    public int trap(int[] height) {
        //尝试单调栈 -- 什么类型的栈才可以接住雨水 先减后增 -- 递减栈
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        int len = height.length;
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && height[stack.peekLast()] < height[i]){
                int bottom = height[stack.removeLast()];
                if(stack.isEmpty()) break;
                int weight = i - stack.peekLast() - 1;
                int h = Math.min(height[i], height[stack.peekLast()]) - bottom;
                res += h * weight;
            }
            stack.addLast(i);
        }
        return res;
    }
}
