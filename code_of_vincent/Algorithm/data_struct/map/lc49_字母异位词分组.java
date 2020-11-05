package Algorithm.data_struct.map;

import java.util.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/26 10:48
 */
public class lc49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //相同的字母作为区分条件，所以可以通过该条件作为key，对应list作为value，实现map
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String s = new String(cs);
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(str);
        }
        List<List<String>> lists = new ArrayList<>();
        for(String str : map.keySet()){
            lists.add(map.get(str));
        }
        return lists;
    }
}
