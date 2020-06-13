package Algorithm.dynamic_programming;

/**
 * @description: 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 注意：word2是固定不变的
 *
 * 尝试素质三连
 *
 * @author: 文琛
 * @time: 2020/6/13 20:03
 */
public class lc72_编辑距离 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(method1(word1, word2));
        System.out.println(method2(word1, word2));
        System.out.println(method3(word1, word2));
    }

    //暴力递归：从前往后比对：三种情况对应于比对不成功的三种选择
    //在word1插入一个字符，使得其和word2对应位置上相等，那么，index2++；
    //在word1删除一个字符，index1++；
    //在word1替换，那么index1++，index2++；
    //上述操作会将操作数+1；
    //而如果比对成功，那么只需要 index1++， index2++ 即可，没有操作数的更新
    private static int method1(String word1, String word2) {
        if(word1.length() == 0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        return fun1(cs1, cs2, 0, 0);
    }

    private static int fun1(char[] cs1, char[] cs2, int i, int j) {
        if(i == cs1.length){
            if(j == cs2.length){
                return 0;
            }else{
                return cs2.length - j;
            }
        }
        if(j == cs2.length){
            return cs1.length - i;
        }
        if(cs1[i] == cs2[j])
            return fun1(cs1, cs2, i+1, j+1);
        int minSteps = 0;
        minSteps = Math.min(fun1(cs1, cs2, i, j+1), fun1(cs1, cs2, i+1, j));
        minSteps = Math.min(minSteps, fun1(cs1, cs2, i+1, j+1));
        return minSteps+1;
    }

    //备忘：i j 相关的二维数组
    static int[][] tab;
    private static int method2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0) return len2;
        if(len2 == 0) return len1;
        tab = new int[len1+1][len2+1];
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        return fun2(cs1, cs2, 0, 0);
    }

    private static int fun2(char[] cs1, char[] cs2, int i, int j) {
        if(i == cs1.length){
            if(j == cs2.length){
                return 0;
            }else{
                return cs2.length - j;
            }
        }
        if(j == cs2.length){
            return cs1.length - i;
        }
        if(tab[i][j] > 0) return tab[i][j];
        if(cs1[i] == cs2[j])
            return fun2(cs1, cs2, i+1, j+1);
        int minSteps = 0;
        minSteps = Math.min(fun2(cs1, cs2, i, j+1), fun2(cs1, cs2, i+1, j));
        minSteps = Math.min(minSteps, fun2(cs1, cs2, i+1, j+1));
        tab[i][j] = minSteps+1;
        return minSteps+1;
    }

    //dp: dp[i][j]代表分别以i， j开头的最少操作数
    private static int method3(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0) return len2;
        if(len2 == 0) return len1;
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] dp = new int[len1+1][len2+1];
        dp[len1][len2] = 0;
        for(int i = 0; i < len1; i++){
            dp[i][len2] = len1 - i;
        }
        for(int i = 0; i < len2; i++){
            dp[len1][i] = len2 - i;
        }
        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                if(cs1[i] == cs2[j]){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j+1]);
                    dp[i][j]++;
                }
            }
        }
        return dp[0][0];
    }
}
