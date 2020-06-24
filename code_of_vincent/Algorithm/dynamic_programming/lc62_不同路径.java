package Algorithm.dynamic_programming;

import java.util.concurrent.TimeoutException;

/**
 * @description: 有个m行*n列的棋盘，机器人每次能向下走一格或者向右走一格，从左上角走到右下角有多少走法
 * @author: 文琛
 * 素质三连：暴力递归 + 备忘录 + dp数组
 * @time: 2020/2/10 9:21
 */
public class lc62_不同路径 {
    public static void main(String[] args) throws TimeoutException {
        int m = 3;
        int n = 3;
        System.out.println(uniquePaths1(m,n));
        System.out.println(uniquePaths2(m,n));
        System.out.println(uniquePaths3(m,n));
    }
    //暴力递归：思路，mn位置上的走法，等同于左边和上边走法的和
    private static int uniquePaths1(int m, int n) {
        //base case
        if(m == 1 && n ==1)
            return 1;
        if(m == 1)
            return uniquePaths1(m,n-1);
        if(n == 1)
            return uniquePaths1(m-1, n);
        return uniquePaths1(m-1, n) + uniquePaths1(m, n-1);
    }
    //备忘录：自顶往下递归，自底往上写入
    private static int[][] tab;
    private static int uniquePaths2(int m, int n) {
        tab = new int[m][n];
        return method2(m,n);
    }

    private static int method2(int m, int n) {
        //base case
        if(m == 1 && n == 1)
            return 1;
        if(tab[m-1][n-1] > 0)
            return tab[m-1][n-1];
        int res;
        if(m == 1){
            res =  method2(m,n-1);
        }else if(n == 1){
            res =  method2(m-1, n);
        }else{
            res =  method2(m-1, n) + method2(m, n-1);
        }
        tab[m-1][n-1] = res;
        return res;
    }
    //dp:自底向上
    private static int uniquePaths3(int m, int n) throws TimeoutException {
        if (m<1||n<1) {
            throw new TimeoutException("输入错误");
        };
        int [][] table = new int[6][5];//表格内数据表示到达该处，可以有多少种走法
        table[0][0] = 0;
        for (int i=1;i<m;i++){
            table[i][0] = 1;
        }
        for (int j=1;j<n;j++){
            table[0][j] = 1;
        }
        for (int x = 1;x<m;x++){
            for (int y=1;y<n;y++){
                table[x][y] = table[x-1][y]+table[x][y-1];
            }
        }
        return table[m-1][n-1];
    }
}
