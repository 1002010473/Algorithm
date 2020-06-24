package Other.知识点;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 *
 * String[] a = c.toArray(new String[0]);

 * 像 toArray 方法一样，此方法充当了基于数组的 API 与基于 collection 的 API 之间的桥梁。
 * 更进一步说，此方法允许在输出数组的运行时类型上进行精确控制，并且在某些情况下，可以用来节省分配开销。
 * 假定 l 是只包含字符串的一个已知 List。以下代码用来将该列表转储到一个新分配的 String 数组：
 *
 * 这里的用new String[0]只是为了指定函数的形参数，最终返回的String[]的长度是由你的list存储内容的长度决定了。
 *
 * new String[0]就是起一个模板的作用，指定了返回数组的类型，0是为了节省空间，因为它只是为了说明返回的类型
 *
 * ArrayList.toArray()需要返回String [] “串对象数组” 类型，
 * 要求调用参数也必须是 “串对象数组”，
 * new String[] 就是生成一个“串对象数组”，[0]表示元素个数为零。

 * @author: 文琛
 * @time: 2020/2/15 11:30
 */
public class ArrayList转换为Array {
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] arr1 = {1,2,3};
        int[] arr2 = {2,3,4};
        list.add(arr1);
        list.add(arr2);
        int[][] objects = list.toArray(new int[0][]);//固定写法
        for (int[] object : objects) {
            for (int i : object) {
                System.out.println(i);
            }
        }
        System.out.println(objects);

    }


    public double[] twoSum(int n) {
        double[][] arr = new double[2][6*n+1];
        for(int i=1;i<=6;i++){
            arr[0][i] = i;
        }
        int flag=1;
        for(int j=2;j<=n;j++){
            for(int k=j;k<=6*j;k++){
                for(int l=1;l<=6;l++){
                    arr[flag][k] += arr[1-flag][k-l];
                }
            }
            flag=1-flag;
        }
        return Arrays.copyOfRange(arr[1-flag],n,6*n);
    }
}
