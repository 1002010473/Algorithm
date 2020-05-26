package twenty;

/**
 * @description:查找旋转数组的最小数字
 * @author: 文琛
 * @time: 2019/11/28 10:43
 */
public class Eleven {
    /*分析：
    * 依据旋转数组的特性，（两个有序的子数组）确定查找方式为二分查找；
    *例如： {3，4，5，1，2}
    * 先将指针指向数组的开头和末尾；0,n-1;
    * 求索引的中间值，将其和首尾值相比较；
    *   如果大于首，则开头的索引值变为该中间值；
    *   如果小于尾，则将末尾的索引值变为该中间值；
    *   (递归需要传递数组和首尾值，不方便)while循环；
    *       直到首尾值相邻时，返回尾的值；
    * ps：1.如果是0个元素进行了旋转，即起始元素小于末尾元素，则立即返回array【0】即可；
    *     2.如果是书上所说，起始 末尾 中间的值都相同，则无法判断在那一部分进行二分查找，只能
    *       进行顺序查找。
    * */
    public static int findMin(int[] array){
        if (array[0]<array[array.length-1]){
            return array[0];
        }
        int s = 0;
        int e = array.length-1;
        while (s<e-1){
            int m = (s+e)/2;
            if (array[s]==array[e]&&array[s]==array[m]){
                return min(array,s,e);
            }

            if (array[m] > array[s]) {
                s=m;
            }else if (array[m] < array[e]){
                e=m;
            }
        }
        return array[e];
    }
    public static int min(int[] array,int start,int end){
        int min = array[start];
        for (int i = start;i<end;i++){
            if (array[i]<min) min = array[i];
        }
        return min;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,1,0,1,1};
        int[] arr2 = {3,4,5,6,7,1,2,3};
        int a = findMin(arr);
        int b = findMin(arr2);
        System.out.println(a+"   "+b);

    }
}
