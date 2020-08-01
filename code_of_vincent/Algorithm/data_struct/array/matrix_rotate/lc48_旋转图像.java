package Algorithm.data_struct.array.matrix_rotate;

/**
 * @description:
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 *
 * 说明：需要原地旋转
 *
 * @author: 文琛
 * @time: 2020/8/1 11:21
 */
public class lc48_旋转图像 {
    public void rotate(int[][] matrix) {
        //进行依次的四个边上对应元素的交换
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++){
            int end = n - 1 - i;
            for(int j = 0; j + i < end; j++){
                int num = matrix[i][i + j];
                matrix[i][i + j] = matrix[end - j][i];
                matrix[end - j][i] = matrix[end][end - j];
                matrix[end][end - j] = matrix[i + j][end];
                matrix[i + j][end] = num;
            }
        }
    }
}
