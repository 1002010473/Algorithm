package Algorithm.mergeIntervals;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 尝试思路：将两个数组合并，然后通过lc56中栈的思路实现重叠空间的计算
 * ps；在题目中已经保证了，各自数组中没有重叠的部分，那么也就保证了重叠的部分必然只是两个不同数组中的区间叠加形成
 * 而不会出现3个叠加的情况
 * @author: 文琛
 * @time: 2020/6/29 11:02
 */
public class lc986_区间列表的交集 {
    public static void main(String[] args) {

    }
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        //按照start的大小安排两个数组的入栈顺序
        //按照start大小入栈，start没有入栈的意义
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            int start, end;
            if(A[i][0] < B[j][0]){
                start = A[i][0];
                end = A[i][1];
                i++;
            }else{
                start = B[j][0];
                end = B[j][1];
                j++;
            }
            if(stack.isEmpty() || stack.peekLast() < start){
                //stack.addLast(start);
                stack.addLast(end);
            }else{
                //重叠部分累加
                list.add(start);
                list.add(Math.min(end, stack.peekLast()));
                //更新end
                if(end > stack.peekLast())
                    stack.addLast(end);
            }
        }
        if( i < A.length){
            while(i < A.length && stack.peekLast() >= A[i][0]){
                list.add(A[i][0]);
                list.add(Math.min(A[i][1], stack.peekLast()));
                i++;
            }
        }
        if( j < B.length){
            while(j < B.length && stack.peekLast() >= B[j][0]){
                list.add(B[j][0]);
                list.add(Math.min(B[j][0], stack.peekLast()));
                j++;
            }
        }
        int size = list.size()/2;
        int[][] arr = new int[size][2];
        int k = 0,l = 0;
        while(k < list.size()){
            arr[l][0] = list.get(k++);
            arr[l++][1] = list.get(k++);
        }
        return arr;
    }
}
