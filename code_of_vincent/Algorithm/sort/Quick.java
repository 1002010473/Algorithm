package Algorithm.sort;

import static Algorithm.sort.Insertion.exchange;

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
        int[] array = {5,2,3,1,4,1};
        sort_Quick(array);
        for (int i:array){
            System.out.println(i);
        }
    }

    private static void sort_Quick(int[] array) {
        sort_Quick(array,0,array.length-1);
    }

    private static void sort_Quick(int[] array, int lo, int hi) {
        //递归的触底返回条件 --- hi == lo 时，已经是递归到单个元素上了，自然有序
        if (lo >= hi)  return;
        int j = partition(array,lo,hi);
        sort_Quick(array,lo,j-1);
        sort_Quick(array,j+1,hi);
    }
    public static int partition(int[] arr, int lo, int hi){
        int comp = arr[lo];
        int bound = lo;
        for(int i = lo + 1; i <= hi; i++){
            if(arr[i] <= comp){ //bound便是小于等于的边界
                bound++; // 从bound向左，包括bound位置都小于等于com
                exchange(arr, bound, i);
            }
        }
        exchange(arr, bound, lo);
        return bound;
    }
}
