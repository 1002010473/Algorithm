package Algorithm.data_struct.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/5 11:03
 */
public class lc480_滑动窗口中位数 {
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        double[] doubles = medianSlidingWindow(nums, 3);
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        //尝试按照数据流的中位数的两个堆的做法实现
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        double[] res = new double[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            if(maxPQ.isEmpty() && minPQ.isEmpty()){
                maxPQ.add(nums[i]);
            }else if(maxPQ.isEmpty()){
                minPQ.add(nums[i]);
            }else if(minPQ.isEmpty()){
                maxPQ.add(nums[i]);
            }else{
                if(nums[i] < maxPQ.peek()){
                    maxPQ.add(nums[i]);
                }else{
                    minPQ.add(nums[i]);
                }
            }
            Tobalance(maxPQ, minPQ);
            if(i - k + 1 >= 0){
                if(maxPQ.size() == minPQ.size()){
                    res[i - k + 1] =maxPQ.peek() / 2.0 + minPQ.peek() / 2.0;
                }else if(maxPQ.size() > minPQ.size()){
                    res[i - k + 1] = maxPQ.peek();
                }else{
                    res[i - k + 1] = minPQ.peek();
                }
                //移除元素
                if(!maxPQ.isEmpty() && nums[i - k + 1] <= maxPQ.peek()){
                    maxPQ.remove(nums[i - k + 1]);
                }else {
                    minPQ.remove(nums[i - k + 1]);
                }
                Tobalance(maxPQ, minPQ);
            }
        }
        return res;
    }
    public static void Tobalance(PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ){
        if(maxPQ.size() > minPQ.size() + 1){
            minPQ.add(maxPQ.poll());
        }
        if(minPQ.size() > maxPQ.size() + 1){
            maxPQ.add(minPQ.poll());
        }
    }
}
