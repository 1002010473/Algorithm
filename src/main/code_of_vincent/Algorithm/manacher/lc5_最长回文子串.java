package Algorithm.manacher;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/27 9:25
 */
public class lc5_最长回文子串 {
    //暴力遍历 -- 最坏情况下的时间复杂度 n的3次方 -- 140 ms
    public String longestPalindrome(String s) {
        //遍历判断以每个字符开头的所有子串，遇到首尾字符相同，尝试将该范围内拿去比对
        int len = s.length();
        if(len == 0) return s;
        int maxLen = 0;
        int left = len, right = len;
        char[] cs = s.toCharArray();
        for(int i = 0; i < len; i++){
            for(int j = len - 1; j >= i; j--){
                if(j - i + 1 <= maxLen)
                    break;
                boolean flag = false;
                if(cs[i] == cs[j]){
                    flag = method(cs, i, j);
                }
                if(flag){
                    int width = j - i + 1;
                    if(width > maxLen){
                        maxLen = width;
                        left = i;
                        right = j;
                    }
                    break;
                }
            }
        }
        return s.substring(left, right + 1);
    }
    public boolean method(char[] cs , int left, int right){
        while(left <= right){
            if(cs[left++] != cs[right--])
                return false;
        }
        return true;
    }

    //dp-- n方级别的复杂度 70ms
    public String longestPalindrome1(String s) {
        // 特判
        int len = s.length();
        if (len < 2)
            return s;

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //按照列进行从上到下的计算，注意 i <= j
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] == charArray[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
