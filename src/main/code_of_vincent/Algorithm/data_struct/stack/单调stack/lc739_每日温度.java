package Algorithm.data_struct.stack.单调stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/22 16:59
 */
public class lc739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
        //右边第一个大于当前值的坐标
        int len = T.length;
        int[] res = new int[len];
        if(len == 0) return res;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = len - 1; i >= 0; i--){
            while(!stack.isEmpty() && T[stack.peekLast()] <= T[i]){
                stack.removeLast();
            }
            if(stack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = stack.peekLast() - i;
            }
            stack.addLast(i);
        }
        return res;
    }
}
