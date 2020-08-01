package Algorithm.data_struct.array.matrix_rotate;


/**
 * @description:顺时针打印矩阵
 * @author: 文琛
 * @time: 2019/12/10 14:28
 */
public class ToOffer顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4,5},
                         {6,7,8,9,10},
                         {11,12,13,14,15}};
        printArray(array);
    }

    private static void printArray(int[][] array) {
        if (array == null || array.length <= 0||array[0].length <= 0) return;
        int rows = array.length;
        int columns = array[0].length;
        int start = 0;
        while (rows > 2 * start && columns > 2 * start){
            printCircle(array,start,rows,columns);
            start++;
        }
    }

    private static void printCircle(int[][] array, int start, int rows, int columns) {
        int endX = columns-1-start;
        int endY = rows-1-start;
        for (int i = start; i <= endX; i++){
            System.out.println(array[start][i]);
        }

        for (int i = start+1; i <= endY; i++){
            System.out.println(array[i][endX]);
        }


        for (int i = endX-1; i >= start; i--){
            System.out.println(array[endY][i]);
        }

        for (int i = endY-1; i > start; i--){
            System.out.println(array[i][start]);
        }
    }
}
