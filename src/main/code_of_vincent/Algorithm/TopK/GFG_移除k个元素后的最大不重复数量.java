package Algorithm.TopK;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/4 14:45
 */
public class GFG_移除k个元素后的最大不重复数量 {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            int len = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[len];
            for(int i = 0; i < len; i++){
                nums[i] = sc.nextInt();
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i : nums){
                map.put(i, map.getOrDefault(i, 0)+1);
            }
            //建立小根堆
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
            for(int i : map.keySet()){
                if(map.get(i) > 1)
                    maxPQ.add(i);
            }
            int pqSize = maxPQ.size();
            int dnum = map.size() - pqSize;
            while(!maxPQ.isEmpty() && k > 0){
                int j = map.get(maxPQ.poll());
                k -= (j - 1);
                if(k >= 0)
                    dnum ++;
            }
            if(k > 0){
                System.out.println(dnum - k);
            }else{
                System.out.println(dnum);
            }

        }
    }
}
