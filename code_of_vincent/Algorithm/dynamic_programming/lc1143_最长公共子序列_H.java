package Algorithm.dynamic_programming;

import java.nio.charset.Charset;

/**
 * @description:给定两个字符串，返回最长公共子序列的长度
 * @author: 文琛
 * @time: 2020/6/10 20:55
 * 尝试暴力三连：（没思路，参考题解）
 */
public class lc1143_最长公共子序列_H {
    public static void main(String[] args) {
        String m = "abcde";
        String n = "ead";
        char[] chars1 = m.toCharArray();
        char[] chars2 = n.toCharArray();
        System.out.println(method1(chars1, chars2));
        System.out.println(method2(chars1, chars2));
        System.out.println(method3(chars1, chars2));
    }

    //暴力递归：试！从头到尾比对，如果字符相等，递归长度+1，不相等，说明其中至少有一个字符不在lcs中，取max递归长度
    private static int method1(char[] chars1, char[] chars2) {
        return fun1(chars1, chars2, 0, 0);
    }
    private static int fun1(char[] m, char[] n, int i, int j) {
        if(i == m.length || j == n.length)
            return 0;
        if(m[i] == n[j]){
            return 1 + fun1(m, n, i+1, j+1);
        }else{
            return Math.max(fun1(m, n, i+1, j), fun1(m, n, i, j+1));
        }
    }
    //备忘录
    //i j -- 二维数组
    public static int[][] tab;
    private static int method2(char[] chars1, char[] chars2) {
        tab = new int[chars1.length][chars2.length];
        return fun2(chars1, chars2, 0, 0);
    }
    private static int fun2(char[] m, char[] n, int i, int j) {
        if(i == m.length || j == n.length)
            return 0;
        if(tab[i][j] > 0)  return tab[i][j];
        int res;
        if(m[i] == n[j]){
            res = 1 + fun1(m, n, i+1, j+1);
        }else{
            res = Math.max(fun1(m, n, i+1, j), fun1(m, n, i, j+1));
        }
        tab[i][i] = res;
        return res;
    }
    //dp--dp[i][j]代表：从i，j位置开始的范围上的最长公共子序列的长度
    private static int method3(char[] m, char[] n) {
        int[][] dp = new int[m.length + 1][n.length + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][n.length] = 0;
        }
        for(int i = 0; i < dp[0].length; i++){
            dp[m.length][i] = 0;
        }
        for(int i = dp.length-2; i >= 0; i--){
            for(int j = dp[0].length-2; j >= 0; j--){
                if(m[i] == n[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }


}
