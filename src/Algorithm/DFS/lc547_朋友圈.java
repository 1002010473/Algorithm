package Algorithm.DFS;

/**
 * @description: 一维数组上的标记DFS递归
 * @author: 文琛
 * @time: 2020/6/15 19:05
 */
public class lc547_朋友圈 {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,1,1},{0,1,1}};
        System.out.println(findCircleNum(grid));

    }
    public static int findCircleNum(int[][] M) {
        boolean[] flags = new boolean[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++){
            if(!flags[i]){
                dfs(M, flags, i);
                count++;
            }
        }
        return count;
    }
    //1D到底，相关联的都D出来了
    private static void dfs(int[][] M, boolean[] flags, int i) {
        flags[i] = true;
        for(int j = 0;  j < M.length; j++){
            if(!flags[j] && M[i][j] == 1){
                dfs(M, flags, j);
            }
        }
    }
}
