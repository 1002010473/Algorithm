package Algorithm.TopK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/4 16:02
 */
public class lc767_字符串重构 {
    //判断 + 递归遍历 ---超时
    String s = null;
    public String reorganizeString(String S) {
        char[] cs = S.toCharArray();
        int maxCou = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : cs){
            int i =  map.getOrDefault(c, 0) + 1;
            map.put(c, i);
            maxCou = Math.max(maxCou, i);
        }
        if(maxCou > (cs.length + 1) / 2)
            return "";
        boolean[] flags = new boolean[cs.length];
        StringBuilder sb = new StringBuilder();
        method(cs, flags, sb);
        return s;
    }
    public void method(char[] cs, boolean[] flags, StringBuilder sb){
        if(s != null)
            return;
        if(sb.length() == cs.length){
            s = sb.toString();
            return;
        }
        for(int i = 0; i < cs.length; i++){
            if(sb.length() == 0 || (sb.charAt(sb.length()-1) != cs[i] && !flags[i])){
                sb.append(cs[i]);
                flags[i] = true;
                method(cs, flags, sb);
                flags[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    //判断 + 堆 -- 7ms
    public String reorganizeString1(String S) {
        char[] cs = S.toCharArray();
        int maxCou = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : cs){
            int i =  map.getOrDefault(c, 0) + 1;
            map.put(c, i);
            maxCou = Math.max(maxCou, i);
        }
        if(maxCou > (cs.length + 1) / 2)
            return "";
        //按照出现次数排列的大根堆
        PriorityQueue<Character> maxPQ = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(char c: map.keySet()){
            maxPQ.add(c);
        }
        //放入的方式：将最多的元素优先放入，当然，需要是实时的一个统计，也就是说，放一个就得重新放入大根堆，立即更新
        //如果不实时更新，则会产生错误，发生最后放不进去的情况
        char[] res = new char[cs.length];
        Arrays.fill(res, '*');
        while(!maxPQ.isEmpty()){
            char c = maxPQ.poll();
            for(int i = 0; i < res.length; i++){
                if(res[i] == '*'){
                    if((i == 0 && res[i+1] != c) || (i == res.length-1 && res[i-1]!=c) || ( res[i-1] != c && res[i+1] != c) ){
                        res[i] = c;
                        break;
                    }
                }
            }
            int num = map.get(c);
            if(num > 1){
                map.put(c, num -1);
                maxPQ.add(c);
            }
        }
        StringBuilder sb= new StringBuilder();
        for(char c : res){
            sb.append(c);
        }
        return sb.toString();
    }
}
