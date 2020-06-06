package Algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * @description:跳台阶问题 lc70
 * 一次可以上1级台阶，也可以上2级台阶。求上n级台阶总共有多少种方法
 * @author: 文琛
 * @time: 2020/2/9 22:46
 *
 * 问题为多少中方法--尝试写暴力递归，再改dp
 */
public class lc70_爬楼梯 {
    public static void main(String[] args) {
        int n = 3;
        int steps = method(0, n);
        System.out.println(steps);
        steps = method2( n);
        System.out.println(steps);
        int num = jump(n);
        System.out.println(num);
    }

    //递归思路：cur为当前位置，cur往上走，cur却决于cur+1和cur+2
    //也可以反过来思考：cur为当前位置，cur有多少种方法取决于cur-1 和 cur-2方法的总和,这样就可以少传入一个n
    private static int method(int cur, int n) {
        //basecase
        if(cur == n)
            return 1;
        int next = method(cur + 1, n);
        int nextnext = 0;
        if(cur + 2 <= n)
            nextnext = method(cur + 2, n);
        return next+nextnext;
    }
    private static int[] arr;
    //改备忘录
    private static int method2( int n){
        arr = new int[n+1];
        Arrays.fill(arr, 0);
        return 0;
    }
    //根据上述递归，此问题为无后效性问题，只需要给定cur就可以确定返回值，一维dp即可
    private static int jump(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        //dp[2]=2;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
