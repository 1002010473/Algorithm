package Algorithm.sort;

import static Algorithm.sort.Selection.exchange;

/**
 * @description:希尔排序 --插入排序的基础上进行的改进  --了解即可
 * h有序数组
 * 时间复杂度 最坏也在n2以下 未能证明
 * 空间复杂度 1
 * @author: 文琛
 * @time: 2019/12/18 16:23
 */
public class Shell {
    public static void main(String[] args) {
        int[] array = {5,1,3,8,6,3};
        sort(array);
        for (int i:array){
            System.out.println(i);
        }
    }

    private static void sort(int[] array) {
        int N = array.length;
        int h = 1;
        while (h<N/3) h = 3*h+1;
        while (h>=1){
            for (int i =1;i<N;i++){
                for (int j=i;j>0&&array[j]<array[j-1];j--){
                    exchange(array,j,j-1);
                }
            }
            h = h/3;
        }
    }
}
