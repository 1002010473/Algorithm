package Algorithm.DFS.Backtracking;

/**
 * @description: 必须相邻，不能重复
 * @author: 文琛
 * @time: 2020/6/17 16:06
 */
public class lc79_矩阵中寻找字符串 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABE";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        boolean[][] flags = new boolean[board.length][board[0].length];
        boolean flag = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(bt(board, flags, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean bt(char[][] board, boolean[][] flags,
                              int i, int j,String word, int index) {
        if(index == word.length())
            return true;
        if(i < 0 || i == board.length || j < 0 || j == board[0].length)
            return false;
        if(!flags[i][j] && board[i][j] == word.charAt(index)){
            flags[i][j] = true;
            boolean flag = false;
            flag = flag || bt(board, flags, i+1, j, word, index+1);
            flag = flag || bt(board, flags, i-1, j, word, index+1);
            flag = flag || bt(board, flags, i, j+1, word, index+1);
            flag = flag || bt(board, flags, i, j-1, word, index+1);
            flags[i][j] = false;
            return flag;
        }
        return false;
    }
}
