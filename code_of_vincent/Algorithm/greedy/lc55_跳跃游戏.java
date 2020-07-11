package Algorithm.greedy;

/**
 * @description: 首先想到的思路 ： dp
 * 贪心（概念比较模糊）
 * @author: 文琛
 * @time: 2020/7/11 14:28
 */
public class lc55_跳跃游戏 {
    //贪心 -- 2ms
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        if(nums.length == 1)
            return true;
        int end = 0;
        for(int i = 0; i < nums.length; i ++){
            if(end < i)
                return false;
            if(end >= nums.length-1)
                return true;
            end = Math.max(end, i + nums[i]);
        }
        return true;
    }
    //素质三连
    //暴力递归 -- 超时
    public boolean canJump1(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        if(nums.length == 1)
            return true;
        return method1(nums, 0);
    }

    private boolean method1(int[] nums, int i) {
        if(i >= nums.length)
            return false;
        if(i == nums.length - 1)
            return true;
        int num = nums[i];
        boolean flag = false;
        for(int j = 1; j <= num; j++){
            flag = flag || method1(nums, i + j);
        }
        return flag;
    }
    //备忘录  -- 1565 ms
    int[] flags;
    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        if(nums.length == 1)
            return true;
        flags = new int[nums.length];
        return method2(nums, 0, flags);
    }
    private boolean method2(int[] nums, int i, int[] flags) {
        if(i >= nums.length)
            return false;
        if(i == nums.length - 1)
            return true;
        if(flags[i] == 1)
            return true;
        if(flags[i] == 2)
            return false;
        int num = nums[i];
        boolean flag = false;
        for(int j = 1; j <= num; j++){
            flag = flag || method2(nums, i + j , flags);
        }
        if(flag){
            flags[i] = 1;
        }else{
            flags[i] = 2;
        }
        return flag;
    }
    //dp -- 1141ms
    public boolean canJump3(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        if(nums.length == 1)
            return true;
        int len = nums.length;
        boolean[] flags = new boolean[len];
        flags[len-1] = true;
        for(int i = len - 2; i >= 0; i--){
            int num = nums[i];
            for(int j = 1; j <= num && (i + j) < len; j++){
                flags[i] = flags[i] || flags[i+j];
                if(flags[i])
                    break;
            }
        }
        return flags[0];
    }
}
