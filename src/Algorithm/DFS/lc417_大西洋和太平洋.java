package Algorithm.DFS;

import javafx.scene.AmbientLight;
import sun.nio.ch.FileKey;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 输出能同时到达大西洋和太平洋的二维矩阵节点坐标
 * @author: 文琛
 * @time: 2020/6/16 10:48
 */
public class lc417_大西洋和太平洋 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return lists;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean[] flags = new boolean[2];
                boolean[][] bs = new boolean[m][n];
                dfs(matrix, flags, bs, i, j);
                if(flags[0] && flags[1]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }
        return lists;

    }

    private void dfs(int[][] matrix, boolean[] flags, boolean[][] bs, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        /*if(i == -1 || j == -1 || i == m || j == n)
            return;*/
        bs[i][j] = true;
        int com = matrix[i][j];
        if(i == 0 || j == 0)
            flags[0] = true;
        if(i == m-1 || j == n-1)
            flags[1] = true;
        if(!flags[0] || !flags[1]){
            if((i+1) < m && matrix[i+1][j] <= com && !bs[i+1][j])
                dfs(matrix, flags, bs,i+1, j);
            if((i-1) > -1 && matrix[i-1][j] <= com && !bs[i-1][j])
                dfs(matrix, flags, bs,i-1, j);
            if((j+1) < n && matrix[i][j+1] <= com && !bs[i][j+1])
                dfs(matrix, flags, bs,i, j+1);
            if((j-1) > -1 && matrix[i][j-1] <= com && !bs[i][j-1])
                dfs(matrix, flags, bs,i, j-1);
        }
    }
}
