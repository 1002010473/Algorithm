package Algorithm.TopK;

import java.util.PriorityQueue;

/**
 * @description: 也可以尝试partation() 时间复杂度为 n --- 见dac
 * @author: 文琛
 * @time: 2020/7/4 11:35
 */
public class lc215_数组中第K大的元素 {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        PriorityQueue<Integer> pq;
        if(2 * k > size){
            k = size - k + 1;
            pq = new PriorityQueue<>((a,b)-> b-a);
        }else{
            pq = new PriorityQueue<>();
        }
        for(int  n : nums){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
