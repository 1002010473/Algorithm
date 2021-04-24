package Algorithm.TopK;



import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @description: 给定一个字符串，请将字符串里的字符按照出现的频率降序排列
 *  类似于347，hashmap + heap
 * @author: 文琛
 * @time: 2020/7/4 11:08
 */
public class lc451_根据字符出现频率排序 {
    public static void main(String[] args) {
        String s = "treer";
        String res = frequencySort(s);
        System.out.println(res);
    }
    public static String frequencySort(String s) {
        if(s == null || s.length() == 0)
            return "";
        char[] cs = s.toCharArray();
        //map统计次数
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : cs){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> maxPQ = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(char c : map.keySet()){
            maxPQ.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(maxPQ.size() > 0){
            char c = maxPQ.poll();
            int count = map.get(c);
            for(int i = 0; i < count; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
