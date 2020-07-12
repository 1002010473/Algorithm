package Algorithm.dp.背包问题;

/**
 * @description:暴力递归改动态规划
 * @author: 文琛
 * @time: 2020/6/4 14:13
 * 两种思路：最小硬币个数从amount出发：一维dp
 *          所有组合方案从数组每个元素出发：二维dp，每个元素依次考虑所有情况
 */
public class lc322_零钱兑换 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        //可组成的方案数
        int amount = 5000;
        System.out.println(System.currentTimeMillis());
        System.out.println(change1(coins,amount));
        System.out.println(System.currentTimeMillis());
        System.out.println(change2(coins,amount));
        System.out.println(System.currentTimeMillis());
        System.out.println(change3(coins,amount));
        System.out.println(System.currentTimeMillis());
        System.out.println();
        //最小硬币个数
        System.out.println(System.currentTimeMillis());
        System.out.println(coinChange1(coins, 30));
        System.out.println(System.currentTimeMillis());
        System.out.println(coinChange2(coins,100));
        System.out.println(System.currentTimeMillis());
        System.out.println(coinChange3(coins, 100));
    }

    //找出能凑出amount的最小coin个数
    //暴力递归改正版：当前amount的最小硬币数 = Math.min(amount-coin 对应的最小硬币数 + 1)；经lc验证超时
    private static int coinChange1(int[] coins, int amount){
        //basecase:amount = 0,res = 0;
        if(amount == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount >= coin){
                int tmp = coinChange1(coins, amount-coin);
                if(tmp == -1)//-1代表此时的amount-coin没有任何兑换方案
                    continue;
                res = Math.min(res, tmp);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res + 1;
    }
    //备忘录版：自顶往下递归，自底往上填充
    private static int[] tab;
    private static int coinChange2(int[] coins, int amount){
        tab = new int[amount+1];
        return method2(coins, amount);
    }

    private static int method2(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(tab[amount] != 0)
            return tab[amount];
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount >= coin){
                int tmp = method2(coins, amount-coin);
                if(tmp == -1)
                    continue;
                res = Math.min(res, tmp);
            }
        }
        res = res == Integer.MAX_VALUE ? -1 : res+1;
        tab[amount] = res;
        return res;
    }
    //动态规划：无后效性问题 且返回值只和amount相关
    public static int coinChange3(int[] coins, int amount) {
        //dp[i] = x 表示，当target为i时，至少需要x枚金币
        //状态转移方程:dp[i] = Math.min(dp[i - coin])+1
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[i] = amount + 1;
        }
        //target = 0，需要0枚硬币,base case
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

    //找出能凑出amount的所有coin组合数 -- 不建议
    //尝试的思路：每个coin所有可能的出现次数：0到正好小于amount的个数
    //1暴力递归
    public static int change1(int[] coins, int amount){
        return method(amount, 0, coins);
    }
    //index代表含义：index及其以后的元素可以使用，aim代表目标和
    //遍历的过程中探讨了每个coin的所有可能性，给定index即意味着之前的coin的可能性都已经探讨完毕
    //真真正正的枚举，不放过任何一种方案，且coin没有重复， 方案也就没有重复
    private static int method(int target, int index, int[] coins) {
        //target == 0 意味着已经可以凑出来了，组合数+1
        if(target == 0)
            return 1;
        //如果遍历完毕，此时如果target==0，代表是一种凑出target的方案，返回1；
        if(index == coins.length)
                return 0;
        //还没遍历完，需要探讨可能性
        int res = 0;
        for(int i = 0; target >= i * coins[index];i++){
            res += method(target - i * coins[index], index+1,coins);
        }
        return res;
    }
    //备忘录
    private static int[][] var;
    private static int change2(int[] coins, int amount){
        //初始化var，也就是dp二维数组
        var = new int[coins.length][amount+1];
        return change2(coins, amount, 0);
    }

    private static int change2(int[] coins, int target, int index) {
        if(target == 0)
            return 1;
        //无方案返回0，从而不用考虑-1
        if(index == coins.length)
            return 0;
        if(var[index][target] > 0)
            return var[index][target];
        int res = 0;
        for(int i = 0; target >= i * coins[index];i++){
            res += change2(coins,target - i * coins[index], index+1);
        }
        var[index][target] = res;
        return res;
    }

    //2改动态规划
    //根据暴力递归，可得，函数由index和target可唯一确定返回结果，从而可根据这两个值建立坐标系
    public static int change3(int[] coins, int amount) {
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
