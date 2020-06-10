package Algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * @description:给定正整数 n
 * 找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n，让组成和的完全平方数的个数最少
 * 由于1的存在，总可以存在组合方案
 * 尝试素质三连：暴归 + 备忘 + dp
 * @author: 文琛
 * @time: 2020/6/9 19:49
 */
public class lc279_完全平方数 {
    public static void main(String[] args) {
        int n = 23;
        System.out.println(method1(n));
        System.out.println(method2(n));
        System.out.println(method3(n));
    }
    //暴力递归：对每个小于cur的完全平方数都计算减去该平方数后的最少个数，这样就可以实现遍历所有方案
    private static int method1(int n) {
        if(n == 0)
            return 0;
        int res = n;
        for(int i = 1; i * i <= n; i++){
            res = Math.min(res, 1 + method1(n-i*i));
        }
        return res;
    }
    //备忘录：自顶向下递归，自底向上写入
    private static int[] tab;
    private static int method2(int n) {
        if(n == 0)
            return 0;
        tab = new int[n+1];
        if(tab[n] > 0)
            return tab[n];
        int res = n;
        for(int i = 1; i * i <= n; i++){
            res = Math.min(res, 1 + method1(n-i*i));
        }
        tab[n] = res;
        return res;
    }
    //dp:自底向上写入
    private static int method3(int n) {
        if(n == 0)
            return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        //遍历dp数组每个位置
        for(int i = 1; i <= n; i++){
            //遍历每个可以减的平方数
            for(int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], 1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
}
