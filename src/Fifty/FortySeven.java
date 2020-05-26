package Fifty;

import java.util.concurrent.TimeoutException;
import java.util.jar.JarEntry;

/**
 * @description: 动态规划 -- 棋盘路线上的礼物最大值 *
 * 左上角 到 右下角 的最大值
 * 二维辅助表格：表格元素表示到达该处时可以拿到礼物的最大值
 * @author: 文琛
 * @time: 2020/2/9 21:35
 */
public class FortySeven {
    public static void main(String[] args){
        int[][] arr = { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 }, { 3, 7, 16, 5 } };
        System.out.println(getMaxValue(arr));
        //System.out.println(getMaxValue(null));
        System.out.println(getMaxValue_1(arr));//该方法在设置边界值的步骤上更加简便，但和前面方法原理一样。
        System.out.println(getMaxValue_2(arr));
    }

    private static int getMaxValue_2(int[][] arr){
        if (arr==null||arr.length==0){
            throw new IllegalArgumentException("输入的数组存在错误");
        }

        int rows = arr.length;
        int cols = arr[0].length;
        int[] array = new int[cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                int left = 0;
                int top = 0;
                if (i>0){
                    top=array[j];
                }
                if (j>0){
                    left=array[j-1];
                }
                array[j] = Math.max(left,top)+arr[i][j];
            }
        }
        return array[cols-1 ];
    }

    private static int getMaxValue_1(int[][] arr)  {
        if (arr==null||arr.length==0){
            throw new IllegalArgumentException("输入的数组存在错误");
        }

        int rows = arr.length;
        int cols = arr[0].length;
        int[][] maxValues = new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                int left=0;
                int top=0;
                if (i>0){
                    top=maxValues[i-1][j];
                }
                if (j>0){
                    left=maxValues[i][j-1];
                }
                maxValues[i][j]=Math.max(left,top)+arr[i][j];//关键函数
            }

        }
        return maxValues[rows-1][cols-1];
    }

    private static int getMaxValue(int[][] arr) {

        if (arr==null||arr.length==0){
            throw new IllegalArgumentException("输入的数组存在错误");
        }
        int[][] maxGift = new int[arr.length][arr[0].length];
        maxGift[0][0] = arr[0][0];

        for (int i=1;i<arr.length;i++){
            maxGift[i][0] = arr[i][0]+maxGift[i-1][0];
        }

        for (int j=1;j<arr[0].length;j++){
            maxGift[0][j]=arr[0][j]+maxGift[0][j-1];
        }
        for (int x=1;x<arr.length;x++){
            for (int y=1;y<arr[0].length;y++){
                maxGift[x][y] = Math.max(maxGift[x-1][y],maxGift[x][y-1])+arr[x][y];//关键函数
            }
        }
        return maxGift[arr.length-1][arr[0].length-1];
    }

}
