package Algorithm.dp.背包问题;

import java.util.Arrays;

/**
 * @description: 零钱兑换的变动版本
 * 给定数量不限的硬币，币值为25分、10分、5分和1分，
 * 编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 注意： 给定了固定的分值，而且有1，所以可以简化判断
 * @author: 文琛
 * @time: 2020/8/11 9:47
 */
public class 面试题08_11 {
    //暴力递归
    public int waysToChange(int n) {
        //组合问题--尝试递归解决
        int[] coins = {1,5,10,25};
        int res = method(n, 3, coins);
        return res;
    }
    public int method(int n, int index, int[] coins){
        if(n == 0 || index == 0)
            return 1;
        int count = 0;
        for(int j = 0; j * coins[index] <= n; j++){
            count += method(n - j * coins[index], index - 1, coins);
            count = count % 1000000007;
        }
        return count;
    }
    //二维dp -- 仍然超时
    public int waysToChange3(int n) {
        //组合问题--尝试二维dp解决
        int[] coins = {1,5,10,25};
        int[][] dp = new int[n+1][4];
        for(int  j = 0;  j < 4; j++){
            for(int i = 0; i <= n; i++){
                if(j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                    for(int k = 1; k * coins[j] <= i; k++){
                        dp[i][j] += dp[i - k * coins[j]][j-1];
                    }
                }
            }
        }
        return dp[n][3];
    }
    //一维dp -- 仍然超时
    public int waysToChange2(int n) {
        //组合问题--尝试二维dp解决
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];

        for(int  j = 0;  j < 4; j++){
            for(int i = n; i >= 0; i--){ // 注意，循环方向必须变化
                if(j == 0){
                    dp[i] = 1;
                }else{
                    for(int k = 1; k * coins[j] <= i; k++){
                        dp[i] += dp[i - k * coins[j]];
                    }
                }
            }
        }
        return dp[n];
    }

    //一维dp改进 -- 55ms
    public int waysToChange5(int n) {
        //组合问题--尝试二维dp解决
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for(int  j = 1;  j < 4; j++){
            for(int i = coins[j]; i <= n; i++){ // 注意，循环方向又发生了变化
                dp[i] =( dp[i] % 1000000007 + dp[i - coins[j]] % 1000000007) % 1000000007;
            }
        }
        return dp[n];
    }
}
