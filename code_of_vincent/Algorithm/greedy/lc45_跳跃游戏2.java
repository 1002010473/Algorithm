package Algorithm.greedy;

import java.util.Arrays;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/11 15:11
 */
public class lc45_跳跃游戏2 {
    //dp -- 全部通过，但是超时
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int len = nums.length;
        int[] flags = new int[len];
        Arrays.fill(flags, len);
        flags[len-1] = 0;
        for(int i = len - 2; i >= 0; i--){
            int num = nums[i];
            for(int j = 1; j <= num && (i + j) < len; j++){
                flags[i] = Math.min(flags[i], flags[i+j] + 1);
            }
        }
        return flags[0];
    }
    // 贪心，思路有点绕，就是贪每次考虑走的下两步的最大值
    public int jump1(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return 0;
        int end = 0;
        int step = 0;
        while(end < len - 1){
            int i = nums[end];
            if(i + end >= len -1)
                return step + 1;
            int maxS = 0;
            int s = 0;
            for(int j = 1; j <= i ; j++){
                if(j + nums[end + j] >= maxS){
                    s = j;
                    maxS = j + nums[end + j];
                }
            }
            end += s;
            step++;
        }
        return step;
    }
}
