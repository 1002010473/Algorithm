package Algorithm.dp;

/**
 * @description:给定一个正整数 n，将其拆分为至少两个正整数，并使拆分的乘积最大化。 返回最大乘积。
 * @author: 文琛
 * @time: 2020/6/9 19:16
 * 素质三连：暴力递归+备忘录+dp
 */
public class lc343_分割整数的最大面积 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(method1(n));
        System.out.println(method2(n));
        System.out.println(method3(n));
    }
    //暴力递归：尝试，n的最大乘积依赖于其拆分后的整数的最大乘积
    private static int method1(int n) {
        //特殊边界排除
        if(n == 2) return 1;
        if(n == 3) return 2;
        return fun1(n);
    }
    //递归主体：返回n分割整数的最大乘积
    private static int fun1(int n) {
        //base case
        if(n < 4)
            return n;
        int max = 1;
        for(int i = 2; i < n / 2 + 1; i++){
            max = Math.max(max,fun1(i) * fun1(n-i));
        }
        return max;
    }
    //备忘录：自顶向下递归，自底向上写入
    private static int[] tab;
    private static int method2(int n) {
        //特殊边界排除
        if(n == 2) return 1;
        if(n == 3) return 2;
        tab = new int[n+1];
        return fun2(n);
    }
    private static int fun2(int n) {
        //base case
        if(n < 4)
            return n;
        if(tab[n] > 0)
            return tab[n];
        int max = 1;
        for(int i = 2; i < n / 2 + 1; i++){
            max = Math.max(max,fun1(i) * fun1(n-i));
        }
        tab[n] = max;
        return max;
    }
    //dp:自底向上的计算
    private static int method3(int n) {
        //特殊边界排除
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n+1];
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            for(int j = 2; j < i / 2 + 1; j++){
                dp[i] = Math.max(dp[i], dp[j] * dp[i-j]);
            }
        }
        return dp[n];
    }
}
