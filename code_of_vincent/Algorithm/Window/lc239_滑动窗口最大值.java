package Algorithm.Window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 线性时间复杂度内解决给定窗口大小内的最大值问题 -- 主要是单调栈的使用
 * @author: 文琛
 * @time: 2020/6/23 18:40
 */
public class lc239_滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] arr = maxSlidingWindow(nums, k);
        for(int i : arr){
            System.out.println(i);
        }
    }
    //尝试将num直接放置到双向队列（双端的一个单调减栈）中去--可行：重复num挨个放置即可
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1)  return nums;
        Deque<Integer> deq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        //从左到右依次进入队列
        for(int i = 0; i < nums.length; i++){
            //按照规则入队
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i]){
                deq.removeLast();
            }
            deq.addLast(i);
            //按照规则出队
            if(i - k >= 0 ){
                if(deq.peekFirst() == i - k)
                    deq.removeFirst();
            }
            if(i - k + 1 >= 0)
                res[i - k + 1] = nums[deq.peekFirst()];
        }
        return res;
    }
}
