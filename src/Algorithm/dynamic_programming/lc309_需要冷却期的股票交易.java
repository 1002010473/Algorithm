package Algorithm.dynamic_programming;

/**
 * @description: 最大利润
 * 可多次交易
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * @author: 文琛
 * @time: 2020/6/12 20:09
 * 素质三连： 暴力递归 + 备忘 + dp
 */
public class lc309_需要冷却期的股票交易 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(method1(prices));
        System.out.println(method2(prices));
        System.out.println(method3(prices));
    }
    //暴力递归：试 + 依赖
    //超时
    private static int method1(int[] prices) {
        //返回以index == 0开头的最大利润
        return fun1(prices, 0);
    }
    //递归主体：以index开头的最大利润
    //index作为开头，只有两种状态：买入，放弃
    private static int fun1(int[] prices, int index) {
        int len = prices.length;
        //if(index == len-1) return 0;
        int res = 0;
        for(int i = index+1; i < len; i++){
            if(prices[index] < prices[i]){
                res = Math.max(res, prices[i] - prices[index] + fun1(prices, i+2));
            }else{
                res = Math.max(res, fun1(prices, i));
            }
        }
        return res;
    }
    //备忘：index相关的一维数组即可
    static int[] tab;
    private static int method2(int[] prices) {
        tab = new int[prices.length];
        return fun2(prices, 0);
    }

    private static int fun2(int[] prices, int index) {
        if(index >= prices.length)
            return 0;
        if(tab[index] > 0)
            return tab[index];
        int len = prices.length;
        int res = 0;
        for(int i = index+1; i < len; i++){
            if(prices[index] < prices[i]){
                res = Math.max(res, prices[i] - prices[index] + fun2(prices, i+2));
            }else{
                res = Math.max(res, fun2(prices, i));
            }
        }
        tab[index] = res;
        return res;
    }
    //dp:dp[i]代表以i为开头（非必须要买入）的最大利润
    private static int method3(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        dp[len-1] = 0;
        for(int i = len - 2; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                if(prices[j] > prices[i]){
                    dp[i] = Math.max(dp[i], prices[j] - prices[i] + dp[Math.min(j+2, len-1)]);
                }else{
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        return dp[0];
    }
}
