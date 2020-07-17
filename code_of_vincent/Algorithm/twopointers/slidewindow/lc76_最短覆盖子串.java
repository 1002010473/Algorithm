package Algorithm.twopointers.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:  完全覆盖时，左移，未完全覆盖时，右移，如果right已经到达了边界，循环结束
 * @author: 文琛
 * @time: 2020/7/17 10:36
 */
public class lc76_最短覆盖子串 {
    public String minWindow(String s, String t) {
        //滑动窗口 -- 覆盖子串中存在重复元素
        if(s == null || t == null || s.length() < t.length() || s.length() == 0 || t.length() == 0)
            return "";
        Map<Character, Integer> mapt = new HashMap<>();
        Map<Character, Integer> maps = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int slen = ss.length;
        for(char c : ts){
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int count = 0, total = ts.length, res = slen + 1;
        int[] arr = new int[2];
        while(left < slen){
            if(count < total){
                if(right == slen) break;
                if(mapt.containsKey(ss[right]) ){
                    if(maps.getOrDefault(ss[right], 0) < mapt.get(ss[right]))
                        count++;
                    maps.put(ss[right], maps.getOrDefault(ss[right], 0)+1);
                }
                right++;
            }else{
                if(right - left < res){
                    res = right - left;
                    arr[0] = left;
                    arr[1] = right - 1;
                }
                if(mapt.containsKey(ss[left])){
                    if(maps.get(ss[left]).equals(mapt.get(ss[left]))) // Integer上最好使用 equals()
                        count--;
                    maps.put(ss[left] , maps.get(ss[left]) - 1);
                }
                left++;
            }
        }
        return res <= slen ? s.substring(arr[0], arr[1]+1) : ""; // substring,小写，而且范围需要注意
    }
}
