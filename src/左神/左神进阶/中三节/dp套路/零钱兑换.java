package 左神.左神进阶.中三节.dp套路;

/**
 * @description:暴力递归改动态规划
 * @author: 文琛
 * @time: 2020/6/4 14:13
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(change2(5,coins));
        System.out.println(change1(2,coins));
    }

    //找出能凑出amount的最小coin个数
    //1.暴力递归
    int res = Integer.MAX_VALUE;
    public int coinChange1(int[] coins, int amount) {
        change(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public void change(int[] coins, int target, int num){
        if(target == 0){
            res = Math.min(num,res);
            return;
        }
        for(int c : coins){
            if(c <= target){
                change(coins, target - c, num+1);
            }
        }
    }
    //2.改动态规划：无后效性问题 而且 返回值只和 target相关
    public int coinChange2(int[] coins, int amount) {
        //dp[i] = x 表示，当target为i时，至少需要x枚金币
        //状态转移方程:dp[i] = Math.min(dp[i - coin])+1
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[i] = amount + 1;
        }
        //target = 0，需要0枚硬币即可
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i ){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    //找出能凑出amount的所有coin组合数
    //1暴力递归
    public static int change1(int amount, int[] coins){
        return method(amount, 0, coins);
    }

    private static int method(int target, int index, int[] coins) {
        if(target == 0)
            return 1;
        //如果遍历完毕，此时如果target==0，代表是一种凑出target的方案，返回1；
        if(index == coins.length){
                return 0;
        }
        //还没遍历完，需要探讨可能性
        int res = 0;
        for(int i = 0; target >= i * coins[index];i++){
            res += method(target - i * coins[index], index+1,coins);
        }
        return res;
    }

    //2改动态规划
    //根据暴力递归，可得，函数由index和target可唯一确定返回结果，从而可根据这两个值建立坐标系
    public static int change2(int amount, int[] coins) {
        //参考左神思路：参数index代表index及其以后的元素可以使用，aim代表目标和
        int num = coins.length;
        int[][] dp = new int[num+1][amount+1];
        //在aim为0时，即代表一种可能性，置为1
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        //返回值为dp[0][amount],状态转移方程dp[index][aim] = dp[index+1][aim]+dp[index][aim - coins[index]];
        //从下往上，每层依次从左到右遍历计算，此处是暴力递归中探讨可能性语句的翻译
        //dp[i][j]可以通过计算i+1，j和i，j-coins[i]来简化讨论，因为i,j-coins[i]已经是其余项目的总和
        for(int i = num - 1; i >= 0; i--){
            for(int j = 0; j <= amount; j++){
                int tmp = j - coins[i] >= 0 ? dp[i][j - coins[i]] : 0;
                dp[i][j] = dp[i+1][j] + tmp ;
            }
        }
        return dp[0][amount];
    }
}
