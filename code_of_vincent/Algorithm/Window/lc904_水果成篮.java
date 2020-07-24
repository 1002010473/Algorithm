package Algorithm.Window;

import java.util.HashMap;

/**
 * @description: 问题转换：找出最多只包含两个值的子串的最大长度
 * @author: 文琛
 * @time: 2020/6/21 16:13
 */
public class lc904_水果成篮 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
    public static int totalFruit(int[] tree) {
        //滑动窗口的变形
        //还是用到hashmap， map中的value为字符出现的次数
        if(tree.length < 3)
            return tree.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        //子串的长度由r - l来表示
        int l = 0, r = 0;
        int maxLen = 0;
        while(r < tree.length){
            map.put(tree[r], map.getOrDefault(tree[r], 0) + 1);
            r++;
            while(map.size() > 2){
                int num = map.get(tree[l]);
                if(num > 1){
                    map.put(tree[l], num-1);
                }else{
                    map.remove(tree[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
    //更快--没有while内层循环
    public static int totalFruit2(int[] tree) {
        //滑动窗口的变形
        //还是用到hashmap， map中的value为字符最后出现的index
        if(tree.length < 3)
            return tree.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        //子串的长度由r - l来表示
        int l = 0, r = 0;
        int maxLen = 0;
        while(r < tree.length){
            map.put(tree[r], r);
            r++;
            if(map.size() > 2){
                int minInd = r;
                for(int i : map.keySet()){
                    minInd = Math.min(minInd, map.get(i));
                }
                int k = 0;
                for(int i : map.keySet()){
                    if(map.get(i) == minInd)
                        k = i;
                }
                map.remove(k);
                l = minInd + 1;
            }
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}
