package Algorithm.data_struct.stack.单调stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/16 10:49
 */
public class lc42_接雨水 {
    public int trap(int[] height) {
        //通过单点减栈实现
        int len = height.length;
        if(len < 3) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < len; i++){
            //相同的元素也要排除，这样在将其作为bottom时，只需要计算一次即可
            while(!stack.isEmpty() && height[stack.peekLast()] <= height[i]){
                int bottom = height[stack.removeLast()];
                if(!stack.isEmpty()){
                    int left = stack.peekLast();
                    int width = i - left - 1;
                    int top = Math.min(height[left], height[i]);
                    res += width * (top - bottom);
                }
            }
            stack.addLast(i);
        }
        return res;
    }
}
