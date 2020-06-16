package Algorithm.DFS;

/**
 * @description: 上下左右四个方向，只需要找到四个方向上DFS到底统计联通面积即可
 * 本题目中的标记对应二维数组， 而且只要经过一次，再也不需要经过第二次，无需标记的撤回
 * @author: 文琛
 * @time: 2020/6/15 16:00
 */
public class lc695_最大岛屿面积 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1},{0,0,1},{0,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!flags[i][j] && grid[i][j] == 1){
                    //DFS
                    int res = method1(grid, flags, i, j);
                    maxArea = Math.max(maxArea, res);
                }
            }
        }
        return maxArea;
    }

    private static int method1(int[][] grid, boolean[][] flags, int i, int j) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || flags[i][j] || grid[i][j] == 0)
            return 0;
        int res = 1;
        flags[i][j] = true;
        res += method1(grid, flags, i+1, j);
        res += method1(grid, flags, i-1, j);
        res += method1(grid, flags, i, j-1);
        res += method1(grid, flags, i, j+1);
        return res;
    }
}
