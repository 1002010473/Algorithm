package Algorithm.dp.背包问题;

/**
 * @description: 背包问题 （暂且不去管什么01、完全的概念）
 * @author: 文琛
 * @time: 2020/7/8 9:46
 */
public class lc1155_骰子掷出target的N种方法 {
    //暴力递归 -- 超时
    public int numRollsToTarget1(int d, int f, int target) {
        //不同的色子取不同值，算作一种额外的组合方法
        if(target <= 0)
            return 0;
        if(d == 1){
            if(target <= f){
                return 1;
            }else{
                return 0;
            }
        }
        int count = 0;
        for(int i = 1; i <= f; i++){
            count += numRollsToTarget1(d-1, f, target - i);
        }
        return count;
    }
    //备忘录：二维 只和target 和 骰子数 有关系
    public static void main(String[] args) {
        int i = numRollsToTarget(2, 6, 7);
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
    }
    static int[][] tab;
    public static int numRollsToTarget(int d, int f, int target) {
        //不同的色子取不同值，算作一种额外的组合方法
        tab = new int[d+1][target+1];
        return method(d, f, target);
    }
    public static int method(int d, int f, int target){
        if(target <= 0)
            return 0;
        if(d == 1){
            if(target <= f){
                return 1;
            }else{
                return 0;
            }
        }
        if(tab[d][target] > 0)
            return tab[d][target];
        int count = 0;
        for(int i = 1; i <= f; i++){
            count += method(d-1, f, target - i);
        }
        tab[d][target] = count;
        return count;
    }
    //dp: 二维数组 -- d 和 target作为index
    //关于取模  mod 的加法性质：最后取模等效于步步取模 (A + B) mod M = (A mod M + B mod M) mod M。
    //计算机则存在风险：你取模之前已经溢出了。而我们在代码里每次迭代都取模，则杜绝了这个风险
    // 另外还可以注意一下， 我们是两两相加之后取模的， 因为 1000000007 * 2 < Integer.MAX_VALUE ，简化了下。
    // 其实我们完全可以写成：dp[i][j] = (dp[i][j] % MOD + dp[i - 1][j - k] % MOD) % MOD。
    public int numRollsToTarget2(int d, int f, int target) {
        int MOD = 1000000007;
        //二维dp，从后往前（target）进行遍历
        int[][] dp = new int[d+1][target+1];
        //从 d = 1 开始
        for(int i = 1; i <= d; i++){
            for(int j = target; j > 0; j--){
                if(i == 1){
                    if(j <= f){
                        dp[i][j] = 1;
                    }
                }else{
                    for(int k = 1; k <= f; k++){
                        if(j >= k){
                            dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % MOD;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return dp[d][target];
    }
    //一维dp
    public int numRollsToTarget3(int d, int f, int target) {
        int MOD = 1000000007;
        //一维dp，从后往前（target）进行遍历
        int[] dp = new int[target+1];
        //从 d = 1 开始
        for(int i = 1; i <= d; i++){
            for(int j = target; j > 0; j--){
                if(i == 1){
                    if(j <= f){
                        dp[j] = 1;
                    }
                }else{
                    dp[j] = 0;
                    for(int k = 1; k <= f; k++){
                        if(j >= k){
                            dp[j] = (dp[j] + dp[j-k]) % MOD;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return dp[target];
    }
}
