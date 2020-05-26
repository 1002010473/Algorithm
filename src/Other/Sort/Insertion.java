package Other.Sort;

/**
 * @description:插入排序 -- 循环遍历并插入，从而实现循环元素的左边都是有序的
 *时间复杂度 最好为n 最坏为n2 平均为n2（或者说时间复杂度应该按照最坏情况来讨论）
 * 空间复杂度 1
 * @author: 文琛
 * @time: 2019/12/17 16:55
 */
public class Insertion {
    public static void main(String[] args) {
        int[] array = {5,1,3,8,6,3};
        sort(array);
        for (int a :array){
            System.out.println(a);
        }
    }

    private static void sort(int[] array) {
        //左边都是有序的---第一位上天然有序，所以从1开始遍历
        for (int i=1;i<array.length;i++){
            //继续循环的条件 -- j > 0 && array[j-1] > array[j]
            for (int j=i;j>0 && array[j-1] > array[j];j--){
                exchange(array,j,j-1);
            }
        }
    }
    public static void exchange(int[] array, int i, int min) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }
}
