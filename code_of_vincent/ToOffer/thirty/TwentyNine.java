package ToOffer.thirty;


import java.util.ArrayList;
import java.util.List;

/**
 * @description:顺时针打印矩阵--- lc54
 * @author: 文琛
 * @time: 2019/12/10 14:28
 */
public class TwentyNine {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        printArray(array);
    }

    private static void printArray(int[][] array) {
        if (array==null) return;
        if (array.length<=0||array[0].length<=0) return;
        int rows = array.length;
        int columns = array[0].length;
        int start = 0;
        while (rows>start*2&&columns>start*2){
            printCircle(array,start,rows,columns);
            start++;
        }
    }

    private static void printCircle(int[][] array, int start, int rows, int columns) {
        int endX = columns-1-start;
        int endY = rows-1-start;
        for (int i = start;i<=endX;i++){
            System.out.println(array[start][i]);
        }
        if (start<endY){
            for (int i =start+1;i<=endY;i++){
                System.out.println(array[i][endX]);
            }
        }
        if (start<endY&&start<endX){
            for (int i = endX-1;i>=start;i--){
                System.out.println(array[endY][i]);
            }
        }
        if (start<endY-1&&start<endX){
            for (int i = endY-1;i>start;i--){
                System.out.println(array[i][start]);
            }
        }

    }
}
//lc54--更清晰的做法
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //尝试按照剑指offer上的方式实现
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        //给定方法实现按圈遍历
        for(int i = 0; 2 * i < m && 2 * i < n; i++){
            method(list, matrix, i, m , n );
        }
        return list;
    }
    public void method(List<Integer> list, int[][] matrix, int i, int m, int n){
        m = m - 1 - i;
        n = n - 1 - i;
        for(int k = i; k <= n; k++){
            list.add(matrix[i][k]);
        }
        for(int k = i + 1; k <= m; k++){
            list.add(matrix[k][n]);
        }
        //通过判断避免重复添加
        if(m > i){
            for(int k = n - 1; k >= i; k--){
                list.add(matrix[m][k]);
            }
        }
        if(n > i){
            for(int k = m - 1; k > i; k--){
                list.add(matrix[k][i]);
            }
        }
    }
}
