package Algorithm.Window;

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
        char[] cs = s.toCharArray();
        int left = 0, right = 0;
        int res = 0;
        while(right < cs.length){
            if(set.contains(cs[right])){
                set.remove(cs[left++]);
            }else{
                set.add(cs[right]);
                res = Math.max(res, right - left + 1);
                right++;
            }
        }
        return res;
    }
    public static int lengthOfLongestSubstring1(String s) {
        //特判
        if(s == null || s.length() == 0)
            return 0;
        char[] cs = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int maxLen = 0;
        while(r < cs.length){
            while(set.contains(cs[r])){
                set.remove(cs[l++]);
            }
            set.add(cs[r++]);
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }
}
