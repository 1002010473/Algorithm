package Algorithm.dp;

/**
 * @description:
 * *符号可以匹配前一个元素0次或多次  .* 相当于.. 可以匹配 ab
 * 每次出现字符 * 时，前面都匹配到有效的字符，就是说不会出现连续的*
 * 动态规划
 * @author: 文琛
 * @time: 2020/11/19 21:04
 */
public class lc10_正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();

        //如果dp维度设置为l1，l2，那么需要考虑在s和p分别为0的情况下的判断，
        //而且由于在状态转移方程中，存在i，j依赖于i，j-2
        //所以需要在二维矩阵中考虑边界情况，所以很是繁琐，不能以这种方式处理
        /*if(l1 == 0 && l2 == 0){
            return true;
        }else if(l1 == 0){
            StringBuilder sb = new StringBuilder(p);
            while(sb.length() > 0){
                if(sb.charAt(sb.length() - 1) == '*'){
                    sb.deleteCharAt(sb.length() - 1);
                    if(sb.length() > 0){
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }else{
                    return false;
                }
            }
            return true;
        }else if(l2 == 0){
            return false;
        }*/

        //考虑通过将dp的维度扩大为l1++, l2++来实现，dp[0][0]代表了s和p中前0个字符进行匹配的结果，true
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;

        //边界情况，j==0的列上，除了00为true，其余都应是false
        //边界行处理，因为状态转移方程中，ij需要依赖到i-1,j
        for(int j = 1; j <= l2; j++){
            if('*' == p.charAt(j - 1) && dp[0][j - 2])
                dp[0][j] = true;
        }
        //普通元素处理
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                //i，j 是二维矩阵的坐标，但是i-1,j-1才是字符串中对应元素
                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    if(p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'){
                        dp[i][j] = dp[i][j-2] || dp[i][j - 1] || dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i][j - 2];
                    }
                }
                //其实还存在 j-1 和 i-1不想等的情况，此时无需判断，保持false
            }
        }
        return dp[l1][l2];
    }

}
