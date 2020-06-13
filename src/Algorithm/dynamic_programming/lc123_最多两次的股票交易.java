package Algorithm.dynamic_programming;

/**
 * @description: 1次或者2次
 * 此题目和k次（lc188）等同
 * @author: 文琛
 * @time: 2020/6/13 11:44
 * 309/714/123/188
 */
public class lc123_最多两次的股票交易 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(method1(prices));
        System.out.println(method2(prices));
        System.out.println(method3(prices));
    }
    //暴力递归：将剩余的交易次数作为参数传入递归
    private static int method1(int[] prices) {
        return fun1(prices, 0, 2);
    }
    //递归主体：还是309、714的逻辑
    private static int fun1(int[] prices, int index, int num) {
        if(num == 0)
            return 0;
        if(index == prices.length)
            return 0;
        int cur = prices[index];
        int res = 0;
        for(int j = index+1; j < prices.length; j++){
            if(prices[j] > cur){
                res = Math.max(res, prices[j] - cur + fun1(prices, j+1, num-1));
            }else{
                res = Math.max(res, fun1(prices, j, num));
            }
        }
        return res;
    }
    //备忘：index 和 num 确定二维数组的备忘
    static int[][] tab;
    private static int method2(int[] prices) {
        tab = new int[prices.length][3];
        return fun2(prices, 0, 2);
    }

    private static int fun2(int[] prices, int index, int num) {
        if(num == 0)
            return 0;
        if(index == prices.length)
            return 0;
        if(tab[index][num] > 0)
            return tab[index][num];
        int cur = prices[index];
        int res = 0;
        for(int j = index+1; j < prices.length; j++){
            if(prices[j] > cur){
                res = Math.max(res, prices[j] - cur + fun2(prices, j+1, num-1));
            }else{
                res = Math.max(res, fun2(prices, j, num));
            }
        }
        tab[index][num] = res;
        return res;
    }
    //dp : dp[i][j] 代表 index = i为起始位置，j次交易以内的最大利润
    //1400ms艰难通过
    private static int method3(int[] prices) {
        if(prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][3];
        // num = 0 时，最大利润为0 ; index = len  -1 时，利润也为0
        for(int j = 1; j <= 2; j++){
            for(int i = prices.length-2; i >= 0; i--){
                for(int k = i+1; k < prices.length; k++){
                    if(prices[k] > prices[i]){
                        dp[i][j] = Math.max(dp[i][j], prices[k] - prices[i] + dp[Math.min(k+1, prices.length-1)][j-1]);
                    }else if(prices[k] < prices[i]){
                        dp[i][j] = Math.max(dp[i][j], dp[k][j]);
                    }
                }
            }
        }
        return dp[0][2];
    }
}
