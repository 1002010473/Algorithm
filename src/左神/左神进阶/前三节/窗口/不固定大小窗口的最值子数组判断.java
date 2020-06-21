package 左神.左神进阶.前三节.窗口;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 求给定数组中 最大值减去最小值 小于或等于 给定num的子数组（连续）的数量
 * 子数组所有可能性：00 01 02 03 04 ---- 0n | 11 12 13 ---1n | 22 23 24 --- 2n| 33------ == n的2次方
 * 要求O（n）时间复杂度
 * @author: 文琛
 * @time: 2020/5/22 22:46
 */
public class 不固定大小窗口的最值子数组判断 {
    public static void main(String[] args) {
        int[] array = {1,2,4};
        int res = method(array,2);
        System.out.println(res);
    }

    private static int method(int[] array, int i) {
        //原理
        //如果一个子数组满足条件，那么该数组所包含的所有子数组都可以满足条件（缩小范围，只会减小数组的最值）
        //如果一个子数组不满足条件，那么包含该数组的所有更大的数组都不可能满足条件（扩大范围，只会增大最值）
        //从0开始维护两个队列，快速判断是否满足条件，找到不满足条件的第一个右边界R，此时，以0开始的子数组数目就是R-0+2
        //此时将L++ -> 1，由于L前进，范围缩小，所以此时的LR组合也可能满足条件，此时可以重复之前的判断
        //遍历一遍，重复上述操作，即可实现数目的统计
        //由于在遍历的过程中R只增不减，所以O（n）
        //需要维护最大值，最小值两个双端队列
        Deque<Integer> maxQue = new LinkedList<>();
        Deque<Integer> minQue = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        //进行循环判断维护
        while(L < array.length){
            while(R < array.length){
                while(!maxQue.isEmpty() && array[maxQue.peekLast()] <= array[R]){
                    maxQue.pollLast();
                }
                while(!minQue.isEmpty() && array[minQue.peekLast()] >= array[R]){
                    minQue.pollLast();
                }
                maxQue.addLast(R);
                minQue.addLast(R);
                if(array[maxQue.peekFirst()] - array[minQue.peekFirst()] > i ){
                    break;
                }
                R++;
            }
            res += R - L ;
            //首先进行判断L对应的index是否过期
            if(maxQue.peekFirst() == L){
                maxQue.pollFirst();
            }
            if(minQue.peekFirst() == L){
                minQue.pollFirst();
            }
            L++;
        }
        return res;
    }
}
