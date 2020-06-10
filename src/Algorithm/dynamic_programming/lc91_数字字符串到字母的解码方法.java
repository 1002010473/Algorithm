package Algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * @description:一条包含字母 A-Z 的消息通过以下方式进行了编码：'A' -> 1 'B' -> 2 ...'Z' -> 26
 * 给定一个只包含数字的非空字符串，计算解码方法的总数。
 * 注意：字符串中不排除0
 * @author: 文琛
 * @time: 2020/6/10 10:01
 */
public class lc91_数字字符串到字母的解码方法 {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(method1(s));
        System.out.println(method2(s));
        System.out.println(method3(s));
    }
    //暴力递归：以cur位置开头的解码方法数 = 以cur+1开头的方法数 + （以cur+2开头的方法数）
    //未超时
    private static int method1(String s) {
        //题目给定了非空，无需特判
        return fun1(s, 0);
    }
    //递归主体：返回以index为起始的方法数
    //0存在的两种情况：1、index；2、index+1
    private static int fun1(String s, int index) {
        int len = s.length();
        if(index == len)
            return 1;
        //0在开头出现，无可能性
        if(s.charAt(index) == '0')
            return 0;
        if(index == len-1)
            return 1;
        int res = 0;
        res += fun1(s, index+1);
        //判断：cur 和 cur+1 位置上的数字组合是否能够在1-26的范围内
        if(s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) < '7'))
            res += fun1(s, index+2);
        return res;
    }
    //备忘录：自顶向下递归，自底向上写入
    private static int[] tab;
    private static int method2(String s) {
        tab = new int[s.length()];
        Arrays.fill(tab, -1);
        return fun2(s, 0);
    }

    private static int fun2(String s, int index) {
        int len = s.length();
        if(index == len)
            return 1;
        //0在开头出现，无可能性
        if(s.charAt(index) == '0'){
            tab[index] = 0;
            return tab[index];
        }
        if(index == len-1){
            tab[index] = 1;
            return 1;
        }
        int res = 0;
        res += fun1(s, index+1);
        //判断：cur 和 cur+1 位置上的数字组合是否能够在1-26的范围内
        if(s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) < '7'))
            res += fun1(s, index+2);
        tab[index] = res;
        return res;
    }
    //dp:自底向上遍历计算
    private static int method3(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        //遍历计算
        for(int i = len-1; i >= 0; i--){
            //如果i上为0，直接为0
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i+1];
            if(i < len-1){
                if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))
                    dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}
