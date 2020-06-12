package Algorithm.dynamic_programming;

/**
 * @description: 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 顺序不同的序列被视作不同的组合。
 * @author: 文琛
 * @time: 2020/6/12 19:33
 * 素质三连：暴力递归 + 备忘 + dp
 */
public class lc377_组合总和 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 35;
        System.out.println(System.currentTimeMillis());
        System.out.println(method1(nums, target));
        System.out.println(System.currentTimeMillis());
        System.out.println(method2(nums, target));
        System.out.println(System.currentTimeMillis());
        System.out.println(method3(nums, target));
    }
    //暴力递归：试，把所有的组合可能性都罗列出来
    //超时
    private static int method1(int[] nums, int target) {
        //base case
        if(target < 0)
            return 0;
        if(target == 0)
            return 1;
        //递归
        int res = 0;
        for(int i : nums){
            res += method1(nums, target - i);
        }
        return res;
    }
    //备忘：target相关的一维数组
    //有改进，仍超时
    static int[] tab;
    private static int method2(int[] nums, int target){
        tab = new int[target + 1];
        return fun2(nums, target);
    }

    private static int fun2(int[] nums, int target) {
        //base case
        if(target < 0)
            return 0;
        if(target == 0)
            return 1;
        if(tab[target] > 0)
            return tab[target];
        //递归
        int res = 0;
        for(int i : nums){
            res += fun2(nums, target - i);
        }
        tab[target] = res;
        return res;
    }
    //dp： dp[i]代表着以i为target的组合数
    private static int method3(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j : nums){
                if(i >= j){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[target];
    }

}
