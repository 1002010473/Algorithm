package Algorithm.twopointers.slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 通过一个set保存当前窗口范围内的字符，发生重复时，将窗口左缩到排除重复的范围即可
 * @author: 文琛
 * @time: 2020/7/16 9:31
 */
public class lc3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while(j<s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }else{
                set.add(s.charAt(j++));
                res = Math.max(res,j-i);
            }
        }
        return res;
    }
}
