package test.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 10:34
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            boolean flag = false;
            for(int i = 0; i < n; i++){
                int j = sc.nextInt();
                if(j <= 0 || j == 2 || j > n){
                    flag = true;
                }
                arr[i] = j;
            }
            if(flag) {
                System.out.println("NO");
                continue;
            }
            Arrays.sort(arr);
            boolean[] flags = new boolean[n];
            fun(flags, arr, 0);
            boolean res = true;
            for(int i = 0; i < flags.length - 1; i++){
                if(!flags[i]){
                    res = false;
                }
            }
            if(res){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static void fun(boolean[] flags, int[] arr,int j) {
        if(j > arr.length) return;
        int target = arr[j];
        if(target == 1) {
            fun(flags, arr, j+1);
        }
        method(flags, arr, target, j - 1, j);
    }

    private static void method(boolean[] flags, int[] arr, int target, int index, int j) {
        if(target == 0) {
            fun(flags, arr, j + 1);
            return;
        }
        if(index < 0) return;
        int k = arr[index];
        if(k <= target){
            method(flags, arr, target, index - 1, j);
            flags[index] = true;
            method(flags, arr, target - k, index - 1, j);
            flags[index] = false;
        }
    }
}