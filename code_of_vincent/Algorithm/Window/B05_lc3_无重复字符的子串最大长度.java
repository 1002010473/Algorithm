package Algorithm.Window;

import java.util.HashSet;

/**
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: 文琛
 * @time: 2020/6/21 18:42
 */
public class B05_lc3_无重复字符的子串最大长度 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
    //字符串的连续子串：滑动窗口
    public static int lengthOfLongestSubstring(String s) {
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
