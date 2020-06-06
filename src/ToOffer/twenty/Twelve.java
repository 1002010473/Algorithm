package ToOffer.twenty;

/**
 * @description:回溯法确定二维矩阵中的路径：难度++
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
        /**
         * @description:
         * @param matrix 二维字符矩阵
         * @param rows   矩阵的行数
         * @param cols   矩阵的列数
         * @param row    当前查找的行
         * @param col    当前查找的列
         * @param str    字符串对象
         * @param pathLength  已经查找到的长度
         * @param visited     映射的是否到过的矩阵
         * @return: boolean
         * @author: Vincent
         * @time: 2019/11/29 14:12
         */

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
    }

    // 测试
    public static void main(String[] args) {
        char[][] matrix = { { 'a', 'b', 't', 'g' }, { 'c', 'f', 'c', 's' }, { 'j', 'd', 'e', 'h' } };
        String str = "abfcea";
        System.out.println(hasPath(matrix, str));
    }

}
