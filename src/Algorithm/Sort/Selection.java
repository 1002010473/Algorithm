package Algorithm.Sort;

/**
 * @description:选择排序 --
 * 时间复杂度 O(n2) 无论序列怎样 都要比较n(n-1)/2次   交换n次
 * 空间复杂度 O(1) 只需要一个临时变量
 * @author: 文琛
 * @time: 2019/12/17 16:43
 */
public class Selection {
    public static void main(String[] args) {
        int[] array = {5,1,3,8,6,3};
        sort(array);
        for (int a :array){
            System.out.println(a);
        }
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length-1; i++){
            //min是指的下标
            int min = i;
            for (int j = i+1 ;j<array.length;j++){
                if (array[j]<array[min])
                    min = j;
            }
            exchange(array,i,min);
        }
    }

    public static void exchange(int[] array, int i, int min) {
        if(i == min)
            return;
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }
}
