package Algorithm.data_struct.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:  栈 用来实现 括号 的匹配
 * @author: 文琛
 * @time: 2020/7/15 19:59
 */
public class lc32_最长有效括号 {
    public int longestValidParentheses(String s) {
        //常规思路 -- 栈
        if(s == null || s.length() == 0)
            return 0;
        Deque<Integer> stack = new LinkedList<>();
        char[] cs = s.toCharArray();
        int len = cs.length;
        boolean[] flags = new boolean[len]; // 记录有效的字符index
        for(int i = 0; i < len; i++){
            if(cs[i] == '('){
                stack.addLast(i);
            }else{
                if(!stack.isEmpty()){
                    int left = stack.removeLast();
                    flags[left] = true;
                    flags[i] = true;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < len; i++){ // 统计有效的index的最大连续长度
            if(flags[i]){
                int j = i;
                while(i < len && flags[i]){
                    i++;
                }
                res = Math.max(res, i - j);
            }
        }
        return res;
    }
}
