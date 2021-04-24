package Algorithm.dp;

import java.util.HashMap;

/**
 * @description:
 * 动态规划尝试三连:暴力递归 + 备忘录 + dp
 * @author: 文琛
 * @time: 2020/6/10 19:10
 */
public class lc808_分汤 {
    public static void main(String[] args) {
        int N = 151;
        System.out.println(method1(N, N));
        System.out.println(method2(N, N));
        System.out.println(method3(N));
    }

    //暴力递归：试，将概率分摊下去，碰到分完的情况返回1
    private static double method1(int A, int B) {
        //同时分完
        if(A <= 0 && B <= 0){
            return 0.5;
        }else if(A <= 0){//A先分完
            return 1;
        }else if(B <= 0){//此时 A > 0
            return 0;
        }
        //最后情况：都>0
        double res = 0;
        res += 0.25 * method1(A-100, B);
        res += 0.25 * method1(A-75, B-25);
        res += 0.25 * method1(A-50, B-50);
        res += 0.25 * method1(A-25, B-75);
        return res;
    }
    //备忘录：自顶向下递归，自底向上写入
    //二维数组超出内存，所以采用hashmap key为“A+B”
    //hashmap也超出内存限制，看来主要在递归上
    private static HashMap<String, Double> tab;
    private static double method2(int A, int B) {
        tab = new HashMap<>();
        return fun2(A, B);
    }

    private static double fun2(int A, int B) {
        //同时分完
        if(A <= 0 && B <= 0){
            return 0.5;
        }else if(A <= 0){//A先分完
            return 1;
        }else if(B <= 0){//此时 A > 0
            return 0;
        }
        String key = A+"+"+B;
        if(tab.containsKey(key))
            return tab.get(key);
        //最后情况：都>0
        double res = 0;
        res += 0.25 * method1(A-100, B);
        res += 0.25 * method1(A-75, B-25);
        res += 0.25 * method1(A-50, B-50);
        res += 0.25 * method1(A-25, B-75);
        tab.put(key,res);
        return res;
    }
    //dp
    //尝试二维数组
    //不满25扣边界很麻烦，所以求余判断
    private static double method3(int N) {
        int little = N % 25;
        int n = N / 25;
        if(little > 0) n++;
        double[][] dp = new double[n+1][n+1];
        dp[0][0] = 0.5;
        for(int i = 1; i <= n; i++){
            dp[0][i] = 1;
            dp[i][0] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] += 0.25 * dp[Math.max(i - 4, 0)][j];
                dp[i][j] += 0.25 * dp[Math.max(i - 3, 0)][j-1];
                dp[i][j] += 0.25 * dp[Math.max(i - 2, 0)][Math.max(j-2, 0)];
                dp[i][j] += 0.25 * dp[i - 1][Math.max(j-3, 0)];
            }
        }
        return dp[n][n];
    }

}
