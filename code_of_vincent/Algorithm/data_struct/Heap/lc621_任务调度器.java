package Algorithm.data_struct.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: 一定数组范围内不能存在重复值，求满足要求安排的最小长度
 * @author: 文琛
 * @time: 2020/8/19 9:36
 */
public class lc621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        //大根堆实现
        int len = tasks.length;
        if(n == 0) return len;
        int[] map = new int[26];
        for(char c : tasks){
            map[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : map){
            if(i > 0)
                pq.add(i);
        }
        int res = 0, k = n + 1;
        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < k && !pq.isEmpty(); i++){
                list.add(pq.poll());
            }
            for(int i : list){
                if(i > 1){
                    pq.add(i - 1);
                }
            }
            if(pq.isEmpty()){
                res += list.size();
            }else{
                res += k;
            }
        }
        return res;
    }
}
