package Algorithm.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个字符串S，找到最长子串的长度，该子串最多包含k个不同的字符
 * @author: 文琛
 * @time: 2020/6/21 15:32
 */
public class lic386_k个不同字符的最长子串长度 {
    public static void main(String[] args) {

    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0)  return 0;
        char[] cs = s.toCharArray();
        int len = cs.length;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while(r < len){
            map.put(cs[r], map.getOrDefault(cs[r++], 0) + 1);
            while(map.size() > k){
                int num = map.get(cs[l]);
                if( num > 1){
                    map.put(cs[l], num-1);
                }else{
                    map.remove(cs[l]);
                }
                l++;
            }
            res = Math.max(res, r-l);
        }
        return res;
    }
}
