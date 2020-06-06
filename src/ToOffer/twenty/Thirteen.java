package ToOffer.twenty;

/**
 * @description:
 * @author: 文琛
 * @time: 2019/11/29 14:48
 */
public class Thirteen {
    private static int number = 0 ;
    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        int k = 1;
        int[][] matrix = new int[m][n];
        System.out.println(hasPath(matrix,k));
    }

    /*public static boolean hasPath(char[][] matrix, String str) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited))
                    return true;
            }
        }
        return false;
    }

    // 上下左右递归搜索
    private static boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, String str,
                                       int pathLength, boolean[][] visited) {
        boolean hasPath = false;
        if (pathLength > str.length() - 1)
            return true;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str.charAt(pathLength)
                && !visited[row][col]) {
            ++pathLength;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }*/

    private static int hasPath(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int row = 0;
        int col = 0;
        canIComeIn(matrix,k,rows,cols,row,col,visited);//从 00 出发，寻找可进入的格子；
        return number;
    }

    private static void canIComeIn(int[][] matrix, int k,int rows,int cols, int row, int col,boolean[][] visited) {


        if (row >= 0 && row < rows && col >= 0 && col < cols && visited[row][col]==false){
            matrix[row][col]= getDigitSum(row)+getDigitSum(col);
            if (matrix[row][col]<k){
                number++;
                visited[row][col] = true;
                canIComeIn(matrix, k, rows,cols,row-1, col,visited);
                canIComeIn(matrix, k, rows,cols,row+1, col,visited);
                canIComeIn(matrix, k, rows,cols,row, col-1,visited);
                canIComeIn(matrix, k, rows,cols,row, col+1,visited);
            }

        }


    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number>0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }
}
