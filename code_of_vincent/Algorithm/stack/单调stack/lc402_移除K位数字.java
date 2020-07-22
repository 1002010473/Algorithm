package Algorithm.stack.单调stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 边界情况复杂，可忽略，和316类似
 * @author: 文琛
 * @time: 2020/7/22 19:39
 */
public class lc402_移除K位数字 {
    public static void main(String[] args) {
        String s = "1432219";
        System.out.println(removeKdigits(s, 3));
    }
    public static String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == k) return "0";
        //特判结束后，进行单调栈的遍历
        char[] cs = num.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        int removed = 0;
        for(int i = 0; i < len; i++){ //通过removed的控制，实现最多去除k个 （特殊情况 “111111”）
            while(!stack.isEmpty() && stack.peekLast() > cs[i]){
                if(removed < k){
                    stack.removeLast();
                    removed++;
                }else{
                    break;
                }
            }
            stack.addLast(cs[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && stack.peekFirst() == '0'){
            stack.removeFirst();
        }
        if(stack.isEmpty())
            return "0";
        for(int i = 0; i < len - k; i++){
            if(!stack.isEmpty()){
                sb.append(stack.removeFirst());
            }
        }
        return sb.toString();
    }
}
