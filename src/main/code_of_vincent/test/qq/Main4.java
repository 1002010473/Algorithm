package test.qq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 20:41
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] help = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            help[i] = arr[i];
        }
        Arrays.sort(help);
        int len = arr.length;
        int left = help[(len / 2) - 1];
        int right = help[len / 2];
        for(int i = 0; i < n; i++){
            if(arr[i] <= left){
                System.out.println(right);
            }else{
                System.out.println(left);
            }
        }
    }
}
