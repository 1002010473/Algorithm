package test;

import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/1 19:21
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        for(int i = 0; i < M; i++){
            arr[i] = sc.nextInt();
        }
        int res = 0;
        boolean[] assist = new boolean[N + 1];
        for(int i : arr){
            res += method(assist, i, N);
        }
        System.out.println(res);
    }

    private static int method(boolean[] assist, int i, int N) {
        int res = 0;
        int count = i;
        while(i <= N){
            if(!assist[i]){
                res++;
                assist[i] = true;
            }
            i += count;
        }
        return res;
    }
}
