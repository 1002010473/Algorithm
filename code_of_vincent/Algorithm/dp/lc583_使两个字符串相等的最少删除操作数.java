package Algorithm.dp;

/**
 * @description: 感觉和最长公共子序列问题等同
 * 返回最小的删除步数
 * @author: 文琛
 * @time: 2020/6/13 15:03
 * 素质三连
 */
public class lc583_使两个字符串相等的最少删除操作数 {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(method1(word1, word2));
        System.out.println(method2(word1, word2));
        System.out.println(method3(word1, word2));
    }

    //暴力递归：思路
    //每个字符串中的字符都有两个状态，删除 or 不删除；
    //需要的是 按照合适的方法进行尝试：比对首字符，如果相等，那么说明两个串中的字符都可以保留
    //如果不等，那么需要去除其中一个后进行递归判断
    private static int method1(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        return fun1(chars1, chars2, 0, 0);
    }

    private static int fun1(char[] chars1, char[] chars2, int i, int j) {
        if(i == chars1.length && j == chars2.length)
            return 0;
        if(i == chars1.length)
            return chars2.length - j;
        if(j == chars2.length)
            return chars1.length - i;
        if(chars1[i] == chars2[j]){
            return fun1(chars1, chars2, i+1, j+1);
        }else{
            return 1 + Math.min(fun1(chars1, chars2, i, j+1), fun1(chars1, chars2, i+1, j));
        }
    }
    //备忘：待写
    private static int method2(String word1, String word2) {
        return 0;
    }
    //dp ： 二维 ： i， j 代表分别以i，j开头的字符串的最少删除次数
    private static int method3(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
         int[][] dp = new int[len1 + 1][len2 + 1];
        dp[len1][len2] = 0;
        for(int i = 0; i < len2; i++){
            dp[len1][i] = len2 - i;
        }
        for(int i = 0; i < len1; i++){
            dp[i][len2] = len1 - i;
        }
        //遍历计算普通i，j处的值
        for(int i = len1-1; i >= 0; i--){
            for(int j = len2-1; j >= 0; j--){
                if(cs1[i] == cs2[j]){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

}
