package Algorithm.TopK;

import java.util.PriorityQueue;

/**
 * @description: 解题思路，每次拿最小的两个连接即可，ps：需要注意，连接后的长度sum需要放置回去
 * @author: 文琛
 * @time: 2020/7/4 9:55
 */
public class lc1167_连接木棒的最小代价 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int cost = method(nums);
        System.out.println(cost);
    }

    private static int method(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n);
        }
        int cost = 0;
        while(pq.size() > 1){
            int sum = pq.poll() + pq.poll();
            cost += sum;
            pq.add(sum);
        }
        return cost;
    }
}
