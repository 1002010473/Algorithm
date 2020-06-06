package 左神.左神进阶.前三节.单调栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * 腾讯真题
 * @author: 文琛
 * @time: 2020/5/23 10:59
 */
public class Buildings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        int[] res = new int[len];
        //单调栈
        Deque<Integer> stack = new LinkedList<>();
        //维护栈：从底往上，递减
        for(int i  = 0; i < len; i++){
            res[i] = stack.size();
            while(!stack.isEmpty() && stack.peekLast() < arr[i]){
                stack.pollLast();
            }
            stack.addLast(arr[i]);
        }
        stack.clear();
        for(int i  = len-1; i >= 0; i--){
            res[i] += stack.size();
            while(!stack.isEmpty() && stack.peekLast() < arr[i]){
                stack.pollLast();
            }
            stack.addLast(arr[i]);
        }
        for(int i: res){
            System.out.println(i+1);
        }
    }
}
