package Algorithm.dynamic_programming;

/**
 * @description: dp入手第一题，(未涉及最值，并不是严格意义上的dp)尝试三种方式
 * 斐波那契数列从0和1开始，f(0) = 0, f(1) = 1,后面每一项数字都是前面两项数字的和，给定n，求f(n)
 * @author: 文琛
 * @time: 2020/6/6 21:46
 */
public class lc509_斐波那契数列 {
    public static void main(String[] args) {
        int n = 5;
        int res = method1(n);
        System.out.println(res);
        res = method2(n);
        System.out.println(res);
        res = method3(n);
        System.out.println(res);
    }
    //暴力递归 O(2^n)
    private static int method1(int n) {
        if(n == 0 || n == 1)
            return n;
        return method1(n-1) + method1(n-2);
    }
    //备忘录：自顶向下递归，但是写入到table中的顺序却是自底向上 O(n)
    private static int[] tab;
    private static int method2(int n) {
        tab = new int[n+1];
        return function(n);
    }
    private static int function(int n) {
        if(n == 0 || n == 1)
            return n;
        if(tab[n] > 0)
            return tab[n];
        int res = function(n-1) + function(n-2);
        tab[n] = res;
        return res;
    }
    //dp:刨除递归，真正的自底向上
    private static int method3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
