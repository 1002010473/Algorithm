package Algorithm.dynamic_programming;

import java.util.concurrent.TimeoutException;

/**
 * @description: 有个m行*n列的棋盘，机器人每次能向下走一格或者向右走一格，从左上角走到右下角有多少走法
 * @author: 文琛
 * @time: 2020/2/10 9:21
 */
public class UniquePaths {
    public static void main(String[] args) throws TimeoutException {
        int m = 2;
        int n = 2;
        int methods = uniquePaths(m,n);
        System.out.println(methods);
    }

    private static int uniquePaths(int m, int n) throws TimeoutException {
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
