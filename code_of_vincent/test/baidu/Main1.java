package test.baidu;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/14 19:03
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] ns = new int[n];
            int[] ms = new int[m];
            for(int i = 0; i < n; i++){
                ns[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++){
                ms[i] = sc.nextInt();
            }
            Arrays.sort(ns);
            Arrays.sort(ms);
            int second = 0;
            for(int i = 0; i < n; i++){
                int target  = ns[i];
                while(second < m && ms[second] < target){
                    second++;
                }
                ns[i] = m - second;
            }
            for(int i : ns){
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
