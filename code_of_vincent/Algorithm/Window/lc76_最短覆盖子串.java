package Algorithm.Window;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:  可以覆盖时，左移，直到不能覆盖，未覆盖时，右移，如果right已经到达了边界，循环结束
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
        int slen = ss.length, total = ts.length;
        for(char c : ts){
            mapt.put(c, mapt.getOrDefault(c, 0) + 1); //统计t中字符出现的次数
        }
        int left = 0, right = 0;
        int count = 0, res = slen + 1;
        int[] arr = new int[2]; //方便保留左右边界
        while(right <= slen){
            if(count < total){
                if(right == slen) break;
                char r = ss[right];
                if( mapt.containsKey(r) ){
                    if(maps.getOrDefault(r, 0) < mapt.get(r))
                        count++;
                    maps.put(r, maps.getOrDefault(r, 0) + 1);
                }
                right++;
            }else{
                if(right - left < res){ //每次进来都要更新res
                    res = right - left;
                    arr[0] = left;
                    arr[1] = right - 1;
                }
                char l = ss[left];
                if(mapt.containsKey(l)){
                    if(maps.get(l).equals(mapt.get(l))) // Integer上最好使用 equals()
                        count--;
                    maps.put(l, maps.get(l) - 1);
                }
                left++;
            }
        }
        return res <= slen ? s.substring(arr[0], arr[1] + 1) : ""; // substring,小写，而且范围需要注意
    }
}
