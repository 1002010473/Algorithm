package 左神.左神进阶.前三节.窗口;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 利用存储index的双端队列实现窗口最大值的快速获取
 *
 * 此题题意；获取给定数组，固定窗口大小的最大值的集合
 *
 * @author: 文琛
 * @time: 2020/5/22 21:27
 */
public class 窗口最大值 {
    public static void main(String[] args) {
        int[] array = {3,2,1,4,7,0,1,9,6}; //数组
        int len = 3; //窗口长度(此题目中该窗口长度固定，左右边界同时右移)
        int[] result = method(array, len);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] method(int[] array, int len) {
        Deque<Integer> queue = new LinkedList<>();
        int index = 0;
        int[] result = new int[array.length - len + 1];
        for(int i = 0; i < array.length; i++){
            //右边界前进
            while(!queue.isEmpty() && array[queue.peekLast()] <= array[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            //左边界前进
            if(queue.peekFirst() == i-len)
                queue.removeFirst();
            //写入到结果数组中
            if(i >= len-1)
                result[index++] = array[queue.peekFirst()];
        }
        return result;
    }
}
