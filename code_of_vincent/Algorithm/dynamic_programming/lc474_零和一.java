package Algorithm.dynamic_programming;

import java.util.HashMap;

/**
 * @description: 假设你分别支配着m个0和n个1。另外，还有一个仅包含0和1组成的字符串的数组。
 * 你的任务是使用给定的m个0和n个1，找到能拼出存在于数组中的字符串的最大数量。每个0和1至多被使用一次。
 * @author: 文琛
 * @time: 2020/6/11 15:30
 * 素质三连
 */
public class lc474_零和一 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(method1(strs, m, n));
        System.out.println(method2(strs, m, n));
        System.out.println(method3(strs, m, n));
    }

    //暴力递归：字符串数组中每个字符串对应着两种状态：配它，不配
    //超时
    private static int method1(String[] strs, int m, int n) {
        return fun1(strs, 0, m, n);
    }
    //递归主体：根据index作为起始位置能够凑出的最大字符串数目
    private static int fun1(String[] strs, int index, int m, int n) {
        //base case
        if(m < 0 || n < 0)
            return -1;
        if(m == 0 && n == 0)
            return 0;
        if(index == strs.length)
            return 0;
        //递归
        int j = 0, k = 0;
        for(char c : strs[index].toCharArray()){
            if(c == '1'){
                k++;
            }else{
                j++;
            }
        }
        int res = 0;
        res = Math.max(fun1(strs,index+1, m, n),1+fun1(strs,index+1,m-j, n-k));
        return res;
    }
    //备忘：三维？hashmap尝试
    static HashMap<String, Integer> map;
    private static int method2(String[] strs, int m, int n) {
        map = new HashMap<>();
        return fun2(strs, 0, m, n);
    }

    private static int fun2(String[] strs, int index, int m, int n) {
        //base case
        if(m < 0 || n < 0)
            return -1;
        if(m == 0 && n == 0)
            return 0;
        if(index == strs.length)
            return 0;
        String s = index + "_" + m + "-" + n;
        if(map.containsKey(s))
            return map.get(s);
        //递归
        int j = 0, k = 0;
        for(char c : strs[index].toCharArray()){
            if(c == '1'){
                k++;
            }else{
                j++;
            }
        }
        int res = 0;
        res = Math.max(fun1(strs,index+1, m, n),1+fun1(strs,index+1,m-j, n-k));
        map.put(s, res);
        return res;
    }
    //dp:三维数组
    private static int method3(String[] strs, int m, int n) {
        int len = strs.length;
        //i = len:代表以index = len为起始的可拼凑字符串个数为0
        int[][][] dp = new int[len+1][m+1][n+1];
        //index依赖的都是index+1，所以从大到小遍历计算
        for(int i = len - 1; i >= 0; i--){
            int x = 0, y = 0;
            for(char c : strs[i].toCharArray()){
                if(c == '1'){
                    y++;
                }else{
                    x++;
                }
            }
            //m,n都依赖小于其的数组元素，所以从小到达的原则进行遍历
            // m = 0, && n = 0 dp[index][m][n] = 0
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    if( j >= x && k >= y){
                        dp[i][j][k] = Math.max(dp[i+1][j][k], 1+dp[i+1][j-x][k-y]);
                    }else{
                        dp[i][j][k] = dp[i+1][j][k];
                    }
                }
            }
        }
        return dp[0][m][n];
    }
}
