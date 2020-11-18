package ToOffer.twenty;

/**
 * @description:回溯法确定二维矩阵中的路径：lc79
 * @author: 文琛
 * @time: 2019/11/29 14:02
 */
public class Twelve {

    public static boolean hasPath(char[][] matrix, String str) {
        /**
         * @description: 第一层方法，根据传入的二维字符矩阵 和 字符串对象，获取必要参数（长度，宽度）、创建对应的判断是否已经走过的矩阵；
         *                以及进行遍历循环，在循环中嵌套第二层方法：针对每一个矩阵元素的查找判断方法；
         * @param matrix 二维矩阵
         * @param str 字符串查找对象
         * @return: boolean
         * @author: Vincent
         * @time: 2019/11/29 14:05
         */

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, i, j, str, 0, visited))
                    return true;
            }
        }
        return false;
    }

    // 上下左右递归搜索
    private static boolean hasPathCore(char[][] matrix, int row, int col, String str,
                                       int index, boolean[][] visited) {
        if (index == str.length())
            return true;
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] != str.charAt(index))
            return false;
        index++;
        visited[row][col] = true;
        boolean hasPath = hasPathCore(matrix, row + 1, col, str, index, visited)
                || hasPathCore(matrix, row, col + 1, str, index, visited)
                || hasPathCore(matrix, row - 1, col, str, index, visited)
                || hasPathCore(matrix, row, col - 1, str, index, visited);
        visited[row][col] = false;
        return hasPath;
    }

    // 测试
    public static void main(String[] args) {
        char[][] matrix = { { 'a', 'b', 't', 'g' }, { 'c', 'f', 'c', 's' }, { 'j', 'd', 'e', 'h' } };
        String str = "abfceh";
        System.out.println(hasPath(matrix, str));
    }

}
