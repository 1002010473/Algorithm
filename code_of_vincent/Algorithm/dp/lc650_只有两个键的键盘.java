package Algorithm.dp;

import java.util.Arrays;

/**
 * @description: 和之前的问题不太一样，看似是有后效性问题，稍微改动一下
 * 尝试素质三连： 暴力递归 + 备忘 + dp
 * @author: 文琛
 * @time: 2020/6/13 21:07
 */
public class lc650_只有两个键的键盘 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(method1(n));
        System.out.println(method2(n));
        System.out.println(method3(n));
    }

    //暴力递归尝试：维护两个参数 hold ： 保存在复制里的个数 ； now ： 现在有的（可以复制的）个数
    //hold必须有，因为涉及到重复粘贴问题，now必须有，涉及到更新复制大小的问题，不可以通过rest替换
    private static int method1(int n) {
        //copy作为起始的操作，步数+1
        return 1 + fun1(1, 1, n);
    }

    private static int fun1(int hold, int now, int n) {
        if(now > n)
            return -1;
        if(now == n)
            return 0;
        int res = Integer.MAX_VALUE;
        //hold 必然小于等于 now
        //int rest = n - now;
        int x = fun1(hold, now + hold, n);
        int y = fun1(now, now + now, n);
        if(x != -1){
            res = Math.min(res, 1 + x);
        }
        if(y != -1){
            res = Math.min(res, 2 + y);
        }
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
    //备忘： 二维数组 hold now
    static int[][] tab;
    private static int method2(int n) {
        if(n == 1) return 0;
        tab = new int[n][n];
        return 1+ fun2(1, 1, n);
    }

    private static int fun2(int hold, int now, int n) {
        if(now > n)
            return -1;
        if(now == n)
            return 0;
        if(tab[hold][now] != 0)
            return tab[hold][now];
        int res = Integer.MAX_VALUE;
        //hold 必然小于等于 now
        int x = fun2(hold, now + hold, n);
        int y = fun2(now, now + now, n);
        if(x != -1){
            res = Math.min(res, 1 + x);
        }
        if(y != -1){
            res = Math.min(res, 2 + y);
        }
        if(res == Integer.MAX_VALUE){
            tab[hold][now] = -1;
            return -1;
        }
        tab[hold][now] = res;
        return res;
    }
    //dp:二维数组
    private static int method3(int n) {
        if(n == 1)
            return 0;
        //只用到1~n范围内的空间
        int[][] dp = new int[n+1][n+1];
        //res = dp[1][1]
        //hold <= res
        for (int[] ints : dp) {
            Arrays.fill(ints, n);
        }
        for(int i = 1; i <= n; i++){
            dp[i][n] = 0;
        }
        for(int i = n-1; i > 0; i--){
            for(int j = n-1; j >= i; j--){
                if(i+j <= n){
                    dp[i][j] = Math.min(dp[i][j], 1+dp[i][j+i]);
                }
                if(j+j <= n){
                    dp[i][j] = Math.min(dp[i][j], 2+dp[j][j+j]);
                }
            }
        }
        return dp[1][1] + 1;
    }
}
