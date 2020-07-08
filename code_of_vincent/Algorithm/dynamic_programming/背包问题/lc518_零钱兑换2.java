package Algorithm.dynamic_programming.背包问题;

/**
 * @description: 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * @author: 文琛
 * @time: 2020/7/8 16:33
 * 尝试素质三连
 */
public class lc518_零钱兑换2 {
    //暴力递归 -- 超时
    public int change(int amount, int[] coins) {
        //思路是确定的，按照组合的遍历方法
        if(amount == 0)
            return 1;
        int min = 0;
        for(int coin : coins){
            min = Math.min(min, coin);
        }
        if(amount < min)
            return 0;
        return method(coins, amount, 0);
    }

    private int method(int[] coins, int amount, int i) {
        if(i == coins.length){
            if(amount == 0){
                return 1;
            }else{
                return 0;
            }
        }
        int res = 0;
        for(int j = 0; j * coins[i] <= amount; j++){
            res += method(coins, amount - j * coins[i], i+1);
        }
        return res;
    }
    //一维dp -- 78ms
    public int change1(int amount, int[] coins) {
        //思路是确定的，按照组合的遍历方法
        if(amount == 0)
            return 1;
        int min = 0;
        for(int coin : coins){
            min = Math.min(min, coin);
        }
        if(amount < min)
            return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = coins.length - 1; i >= 0; i--){
            for(int j = amount; j >= coins[i]; j--){ //从右往左算，那么只能依赖下一层
                for(int k = 1; k * coins[i] <= j; k++){
                    dp[j] += dp[j - k * coins[i]];
                }
            }
        }
        return dp[amount];
    }
    //一维dp： 改进 -- 3ms
    public int change2(int amount, int[] coins) {
        //思路是确定的，按照组合的遍历方法
        if(amount == 0)
            return 1;
        int min = 0;
        for(int coin : coins){
            min = Math.min(min, coin);
        }
        if(amount < min)
            return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = coins.length - 1; i >= 0; i--){
            for(int j = coins[i]; j <= amount; j++){ //从左往右算，那么算作一种优化，j-coins[i] 上已经算过了
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

}
