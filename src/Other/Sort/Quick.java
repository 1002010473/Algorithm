package Other.Sort;

import Fifty.Fifty_2;

import static Other.Sort.Insertion.exchange;

/**
 * @description:快速排序 -- 分治思想（递归）--从上而下
 * 时间复杂度 nlog n 最坏情况是该数组已经有序了 此时复杂度为 n2
 * 空间复杂度 -- 递归的深度 ----平均需要递归 log n  则复杂度也为 log n
 *
 * 经leetcode验证无误
 *
 * @author: 文琛
 * @time: 2019/12/19 14:34
 */
public class Quick {
    public static void main(String[] args) {
        int[] array = {5,2,3,1};
        sort_Quick(array);
        for (int i:array){
            System.out.println(i);
        }
    }

    private static void sort_Quick(int[] array) {
        sort_Quick(array,0,array.length-1);
    }

    private static void sort_Quick(int[] array, int lo, int hi) {
        //递归的触底返回条件--- hi == lo 时，已经是递归到单个元素上了，自然有序
        if (hi<=lo) return;
        int j = partition(array,lo,hi);
        sort_Quick(array,lo,j-1);
        sort_Quick(array,j+1,hi);
    }

    private static int partition(int[] array, int lo, int hi) {
        int left = lo;
        int right = hi;
        int comp = array[lo];
        while(left<right){
            //必须将顶部的缩短循环放在前面
            // 以防出现将底部增长放在前面时，comp就是最小元素却出现将其和lo+1上的元素进行替换的操作
            //同时，末尾存在将lo和left相交换的操作，必须让left和right在小于comp处相遇
            while (left<right && array[right]>=comp)
                right--;
            while(left<right && array[left]<=comp)
                left++;
            exchange(array,left, right);
        }

        exchange(array,lo,left);
        return left;
    }
}
