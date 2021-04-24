package Algorithm.dp.背包问题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/7 21:54
 */
public class lc1425_带限制的子序列和 {
    //暴力递归 + 稍微的优化   ---  超时
    public int constrainedSubsetSum(int[] nums, int k) {
        //如果num全是小于0的，返回一个最大值即可
        //如果num并不全是负数，那么只需要从正数开始作为起点尝试即可
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            max = Math.max(max, nums[i]);
        }
        if(max <= 0)
            return max;
        int res = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                res = Math.max(res, method(nums, i, k));
            }
        }
        return res;
    }
    public int method(int[] nums, int index, int k){
        if(index >= nums.length)
            return 0;
        int count = nums[index];
        int max = -1;
        for(int i = 1; i <= k; i++){
            max = Math.max(max, method(nums, index + i, k));
        }
        return max <= 0 ? count : count + max;
    }
    //备忘录： 一维数组即可 -- 还是超时
    int[] arr;
    boolean[] flags;
    public int constrainedSubsetSum1(int[] nums, int k) {
        //如果num全是小于0的，返回一个最大值即可
        //如果num并不全是负数，那么只需要从正数开始作为起点尝试即可
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            max = Math.max(max, nums[i]);
        }
        if(max <= 0)
            return max;
        int res = 0;
        arr = new int[len];
        flags = new boolean[len];
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                res = Math.max(res, method1(nums, i, k));
            }
        }
        return res;
    }
    public int method1(int[] nums, int index, int k){
        if(index >= nums.length)
            return 0;
        if(flags[index])
            return arr[index];
        int count = nums[index];
        int max = -1;
        for(int i = 1; i <= k; i++){
            max = Math.max(max, method1(nums, index + i, k));
        }
        int res = ( max <= 0 ? count : count + max);
        arr[index] = res;
        flags[index] = true;
        return res;
    }
    //老老实实dp吧 -- O nk 时间复杂度  -- 还是超时
    public int constrainedSubsetSum2(int[] nums, int k) {
        //如果num全是小于0的，返回一个最大值即可
        //如果num并不全是负数，那么只需要从正数开始作为起点尝试即可
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            max = Math.max(max, nums[i]);
        }
        if(max <= 0)
            return max;
        int res = 0;
        int[] dp = new int[len];
        //从后往前遍历比较取值
        for(int i = len - 1; i >= 0; i--){
            int count = nums[i];
            int m = 0;
            for(int j = 1; j <= k; j++){
                if((i + j) >= len){
                    break;
                }else{
                    m = Math.max(m, dp[i+j]);
                }
            }
            if(m > 0)
                count += m;
            dp[i] = count;
            res = Math.max(res, count);
        }
        return res;
    }
    //dp优化 -- n是必须的啦， 只能在k上进行尝试 ： 快速获取k个后继元素中的最大值--单调队列
    public int constrainedSubsetSum3(int[] nums, int k) {
        //如果num全是小于0的，返回一个最大值即可
        //如果num并不全是负数，那么只需要从正数开始作为起点尝试即可
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            max = Math.max(max, nums[i]);
        }
        if(max <= 0)
            return max;
        int res = 0;
        int[] dp = new int[len];
        //单调队列，用以实现k个元素快速获取最大值 -- 存放 index
        Deque<Integer> queue = new LinkedList<>();
        //从后往前遍历比较取值
        for(int i = len - 1; i >= 0; i--){
            if(!queue.isEmpty() && queue.peekFirst() == i + k + 1){
                queue.removeFirst();
            }
            int count = nums[i];
            int m = 0;
            if(!queue.isEmpty()) {
                m = dp[queue.peekFirst()];
            }
            if(m > 0)
                count += m;
            dp[i] = count;
            res = Math.max(res, count);
            while(!queue.isEmpty() && dp[queue.peekLast()] < count){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        return res;
    }
}
