package Algorithm.DFS;

/**
 * @description: 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 排除法：先遍历边界上节点，找到其中的O，将边界上的O相关联的节点标记位true，然后再遍历非边界节点，
 * 此时，只要为false的O都改成X即可
 * @author: 文琛
 * @time: 2020/6/16 9:58
 */
public class lc130_被围绕的区域 {
    public static void main(String[] args) {
        char[][] board = new char[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                board[i][j] = 'X';
            }
        }
        board[1][1] = 'O';
        method1(board);
    }

    private static void method1(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        boolean[][] flags = new boolean[m][n];
        //遍历一圈的边界节点，寻找O
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O' && !flags[0][j]){
                dfs1(board, flags, 0, j);
            }
            if(board[m-1][j] == 'O' && !flags[m-1][j]){
                dfs1(board, flags, m-1, j);
            }
        }
        for(int j = 1; j < m-1; j++){
            if(board[j][0] == 'O' && !flags[j][0]){
                dfs1(board, flags, j, 0);
            }
            if(board[j][n-1] == 'O' && !flags[j][n-1]){
                dfs1(board, flags, j, n-1);
            }
        }
        //遍历中间的节点，查找未被标记的O并DFS遍历修改
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                dfs2(board, flags, i, j);
            }
        }
    }

    private static void dfs2(char[][] board, boolean[][] flags, int i, int j) {
        if(i < 0 || i == board.length || j < 0 || j == board[0].length)
            return;
        if(board[i][j] == 'O' && !flags[i][j]){
            board[i][j] = 'X';
            dfs2(board, flags, i+1, j);
            dfs2(board, flags, i-1, j);
            dfs2(board, flags, i, j-1);
            dfs2(board, flags, i, j+1);
        }
    }

    //DFS遍历标记未被包围的节点
    private static void dfs1(char[][] board, boolean[][] flags, int i, int j) {
        if(i < 0 || i == board.length || j < 0 || j == board[0].length)
            return;
        if(board[i][j] == 'O' && !flags[i][j]){
            flags[i][j] = true;
            dfs1(board, flags, i+1, j);
            dfs1(board, flags, i-1, j);
            dfs1(board, flags, i, j+1);
            dfs1(board, flags, i, j-1);
        }
    }
}
