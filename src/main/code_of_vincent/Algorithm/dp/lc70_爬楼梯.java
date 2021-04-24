package Algorithm.dp;

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
        int n = 10;
        System.out.println(method1(n));

        System.out.println(method2(n));

        System.out.println(method3(n));
    }
    //递归思路：cur为当前位置，cur有多少种方法取决于cur-1 和 cur-2方法的总和
    //超时
    private static int method1(int cur) {
        //basecase
        if(cur == 1 || cur == 2)
            return cur;
        return method1(cur-1) + method1(cur-2);
    }
    //备忘录：自顶向下递归，自底往上填充
    //通过
    private static int[] arr;
    private static int method2(int n){
        arr = new int[n+1];
        return fun(n);
    }

    private static int fun(int n) {
        if(n == 1 || n == 2)
            return n;
        if(arr[n]!=0)
            return arr[n];
        int res = fun(n-1) + fun(n-2);
        arr[n] = res;
        return res;
    }

    //根据上述递归，此问题为无后效性问题，只需要给定cur就可以确定返回值，一维dp即可
    //dp：自底向上直接遍历计算
    private static int method3(int n) {
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
