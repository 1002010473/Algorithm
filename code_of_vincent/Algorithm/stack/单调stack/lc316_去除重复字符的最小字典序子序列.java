package Algorithm.stack.单调stack;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/22 17:53
 */
public class lc316_去除重复字符的最小字典序子序列 {
    public String removeDuplicateLetters(String s) {
        //遍历一遍数组，统计每个字符的个数
        if(s.length() == 0) return "";
        int[] count = new int[26];
        char[] cs = s.toCharArray();
        for(char c : cs){
            count[c - 'a'] += 1;
        }
        //单调增stack，用来实现字典序最小 -- 存储index
        Deque<Integer> stack = new LinkedList<>();
        //hashset,统计是否栈中有对应字符
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < cs.length; i++){
            if(set.contains(cs[i])){ //如果stack中已经有了cs[i]，那么只需要将count--就可以了，不要压栈
                count[cs[i] - 'a'] -= 1;
                continue;
            }
            //单调递增栈，只有当违背递增原则时且last对应的字符还有剩余时，才可以抛出
            while(!stack.isEmpty() && cs[stack.peekLast()] > cs[i] && count[cs[stack.peekLast()] - 'a'] > 0){
                int j = stack.removeLast();
                set.remove(cs[j]);
            }
            stack.addLast(i);
            set.add(cs[i]);
            count[cs[i] - 'a'] -= 1;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(cs[stack.removeLast()]);
        }
        return sb.reverse().toString();
    }
}
