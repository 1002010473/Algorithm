package Algorithm.dp;

import java.util.Arrays;

/**
 * @description: 等同于lc123（最多两次）
 * @author: 文琛
 * @time: 2020/6/13 14:03
 * 309/714/123/188/(非dp问题 121 122)
 */
public class lc188_最多k次的股票交易 {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        int k = 2;
        System.out.println(method1(prices,k));
        System.out.println(method2(prices,k));
        System.out.println(method3(prices,k));
    }



    //dp:超内存
    private static int method1(int[] prices, int n) {
        if(prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][n+1];
        // num = 0 时，最大利润为0 ; index = len  -1 时，利润也为0
        for(int j = 1; j <= n; j++){
            for(int i = prices.length-2; i >= 0; i--){
                for(int k = i+1; k < prices.length; k++){
                    if(prices[k] > prices[i]){
                        dp[i][j] = Math.max(dp[i][j], prices[k]-prices[i] + dp[Math.min(k+1, prices.length-1)][j-1]);
                    }else if(prices[k] < prices[i]){
                        dp[i][j] = Math.max(dp[i][j], dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n];
    }
    //dp改进：两条数组交替实现
    //超出时间限制
    private static int method2(int[] prices, int n) {
        int len = prices.length;
        if(len == 0)
            return 0;
        //起始位置上，dp1代表 n = 0； dp2 代表 n = 1
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for(int j = 1; j <= n; j++){
            for(int i = len-2; i >= 0; i--){
                for(int k = i+1; k < len; k++){
                    if(prices[k] > prices[i]){
                        dp2[i] = Math.max(dp2[i], prices[k]-prices[i] + dp1[Math.min(k+1, prices.length-1)]);
                    }else if(prices[k] < prices[i]){
                        dp2[i] = Math.max(dp2[i], dp2[k]);
                    }
                }
            }
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
            Arrays.fill(dp2, 0);
        }
        return dp1[0];
    }
    //dp再改进：两条数组交替实现 + 当n>len/2时，即变成了没有次数的最大利润求解，此时将数据量大的问题简化
    //
    private static int method3(int[] prices, int n) {
        int len = prices.length;
        if(len == 0)
            return 0;
        if((len / 2) <= n)
            return method4(prices);
        //起始位置上，dp1代表 n = 0； dp2 代表 n = 1
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for(int j = 1; j <= n; j++){
            for(int i = len-2; i >= 0; i--){
                for(int k = i+1; k < len; k++){
                    if(prices[k] > prices[i]){
                        dp2[i] = Math.max(dp2[i], prices[k]-prices[i] + dp1[Math.min(k+1, prices.length-1)]);
                    }else if(prices[k] < prices[i]){
                        dp2[i] = Math.max(dp2[i], dp2[k]);
                    }
                }
            }
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
            Arrays.fill(dp2, 0);
        }
        return dp1[0];
    }
    //不限次数，随便交易
    private static int method4(int[] prices) {
        int result = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1])
                result += prices[i] - prices[i-1];
        }
        return result;
    }

}
