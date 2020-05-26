package thirty;

import java.util.Arrays;

/**
 * @description:数组的奇偶排序
 * @author: 文琛
 * @time: 2019/12/4 11:30
 */
public class TwentyOne {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        reorderOddEven(array);
        System.out.println(Arrays.toString(array));
    }

    private static void reorderOddEven(int[] array) {
        int front = 0;
        int end = array.length-1;
        while (end>front){
            if (isEven(array[front])){
               if (!isEven(array[end])){
                   exchange(array,front,end);
                   end--;
               }else{
                   end--;
                   continue;
               }
            }
            front++;
        }
    }
    private static boolean isEven(int num){
        return num%2 == 0;
    }

    private static void exchange(int[] array, int front, int end) {
        int temp = array[front];
        array[front] = array[end];
        array[end] = temp;
    }
}
