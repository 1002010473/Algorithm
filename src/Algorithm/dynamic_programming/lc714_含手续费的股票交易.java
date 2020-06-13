package Algorithm.dynamic_programming;

/**
 * @description: 给定一个整数数组 prices，其中第i个元素代表了第i天的股票价格；非负整数fee代表了交易的手续费用
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 返回获得利润的最大值。
 * @author: 文琛
 * @time: 2020/6/13 10:33
 * 素质三连：暴力递归 + 备忘 + dp
 * 309/714
 */
public class lc714_含手续费的股票交易 {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(method1(prices, fee));
        System.out.println(method2(prices, fee));
        System.out.println(method3(prices, fee));
    }
    //暴力递归：试 当前index为起始点，而非买入点，依赖其后的卖出点之后的递归值
    private static int method1(int[] prices, int fee) {
        return fun1(prices, 0, fee);
    }
    //递归主体：返回最大利润
    private static int fun1(int[] prices, int i, int fee) {
        if(i == prices.length)
            return 0;
        int cur = prices[i];
        int res = 0;
        for(int j = i+1; j < prices.length; j++){
            if(prices[j] - fee > cur){
                res = Math.max(res, prices[j] - cur - fee + fun1(prices, j+1, fee));
            }else{
                res = Math.max(res, fun1(prices, j, fee));
            }
        }
        return res;
    }
    //备忘：有改进，依旧超时
    static int[] tab;
    private static int method2(int[] prices, int fee) {
        tab = new int[prices.length];
        return fun2(prices, 0, fee);
    }

    private static int fun2(int[] prices, int i, int fee) {
        if(i == prices.length)
            return 0;
        if(tab[i] > 0)
            return tab[i];
        int cur = prices[i];
        int res = 0;
        for(int j = i+1; j < prices.length; j++){
            if(prices[j] - fee > cur){
                res = Math.max(res, prices[j] - cur - fee + fun2(prices, j+1, fee));
            }else{
                res = Math.max(res, fun2(prices, j, fee));
            }
        }
        tab[i] = res;
        return res;
    }
    //dp : dp[i]代表以i为起始的最大利润
    //超时
    private static int method3(int[] prices, int fee) {
        int len = prices.length;
        int[] dp = new int[len];
        dp[len-1] = 0;
        for(int i = len-2; i >= 0; i--){
            for(int j = i+1 ; j < prices.length; j++){
                if(prices[j] - prices[i] > fee){
                    dp[i] = Math.max(dp[i], dp[Math.min(j+1, len-1)] + prices[j] - prices[i] -fee);
                }else{
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        return dp[0];
    }
}
