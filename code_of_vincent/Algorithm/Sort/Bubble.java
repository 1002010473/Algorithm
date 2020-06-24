package Algorithm.Sort;

/**
 * @description:冒泡排序
 * 时间复杂度 n2---不论序列如何 都要比较n(n-1)/2  交换的次数可能为0 也可能为比较一次 交换一次
 * 空间复杂度 1
 * @author: 文琛
 * @time: 2019/12/18 15:21
 */
public class Bubble {
    public static void main(String[] args) {
        int[] array = {5,4,3,8,6,3};
        //int[] array = {1,3,3,5,6,8};
        //sort(array);
        sort_(array);
        for (int a :array){
            System.out.println(a);
        }

    }
    //冒泡排序的优化
    //设置标志位
    private static void sort_(int[] array) {
        //特判
        if(array == null|| array.length < 2)
            return;
        //标志位
        boolean hasSwaped ;
        for (int i =0;i<array.length-1;i++){
            hasSwaped = false;
            for (int j=1;j<array.length-i;j++){
                if (array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    hasSwaped = true;
                }
            }
            if (!hasSwaped)
                return ;
        }
    }

    private static void sort(int[] array) {
        //外层遍历--从0到length-2（如果到了length-1，那么最后一次第二层循环并不执行）
        for (int i =0;i<array.length-1;i++){
            //内层遍历--从1到i对应上限（可以通过i=0时进行确定上限的具体表达式--例如：i=0,那么上限肯定是数组最后一位，所以j<length-i）
            for (int j=1;j<array.length-i;j++){
                if (array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

}
