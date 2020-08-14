package Algorithm.dp;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/14 9:35
 */
public class lc96_不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= i; j++){
                int left = dp[j - 1];
                int right = dp[i - j];
                count += left * right;
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
