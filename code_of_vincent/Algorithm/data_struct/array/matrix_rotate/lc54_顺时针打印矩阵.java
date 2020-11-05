package Algorithm.data_struct.array.matrix_rotate;


import java.util.ArrayList;
import java.util.List;

/**
 * @description:顺时针打印矩阵
 * @author: 文琛
 * @time: 2019/12/10 14:28
 */
public class lc54_顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4,5},
                         {6,7,8,9,10},
                         {11,12,13,14,15}};
        List<Integer> list = spiralOrder(array);
        for(int i : list){
            System.out.println(i);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        //按圈遍历
        List<Integer> list = new ArrayList<>();
        int left = 0, top = 0;
        int bottom = matrix.length;
        if(bottom == 0) return list;
        bottom--;
        int right = matrix[0].length;
        if(right == 0) return list;
        right--;
        while(left <= right && bottom >= top){
            method(matrix, left++, right--, top++, bottom--, list);
        }
        return list;
    }
    public static void method(int[][] matrix, int left, int right, int top, int bottom, List<Integer> list){
        //上面的行
        for(int i = left; i <= right; i++){//注意边界的范围，如果此时四个边界都按照[left, right)的方式打印，此时对于只有一个元素的打印来说，相当于直接返回
            list.add(matrix[top][i]);
        }
        //右边的列
        for(int i = top + 1; i <= bottom; i++){
            list.add(matrix[i][right]);
        }
        //上述两个边界的范围改动也就是说，在一行，或者一列，一个元素的时候，上面两个打印步骤至少要全覆盖
        //因为下面的判断会直接跳过对应的遍历
        //底下的行
        if(bottom > top){
            for(int i = right - 1; i > left; i--){
                list.add(matrix[bottom][i]);
            }
        }
        //左边的列
        if(right > left){
            for(int i = bottom; i > top; i--){
                list.add(matrix[i][left]);
            }
        }
    }
}
