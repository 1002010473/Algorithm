package Algorithm.DFS;

import sun.swing.plaf.GTKKeybindings;

import javax.swing.*;

/**
 * @description: 比求解最大岛屿面积问题更简单，只需要遍历一遍标记即可，不需要求面积
 * @author: 文琛
 * @time: 2020/6/15 16:32
 */
public class lc200_岛屿数量 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1},{0,0,0},{0,1,1}};
        System.out.println(numIslands(grid));
    }

    private static int numIslands(int[][] grid) {
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!flags[i][j] && grid[i][j] == 1){
                    count++;
                    //DFS用来实现标记相通位置
                    method1(grid, flags, i, j);
                }
            }
        }
        return count;
    }

    private static void method1(int[][] grid, boolean[][] flags, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            if(!flags[i][j] && grid[i][j] == 1){
                flags[i][j] = true;
                method1(grid, flags, i+1, j);
                method1(grid, flags, i-1, j);
                method1(grid, flags, i, j+1);
                method1(grid, flags, i, j-1);
            }
        }
    }
}
