package test.card;

import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/21 19:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for(int i = 1; i < n+1; i++){
                int k = sc.nextInt();
                arr[i] = k % 2;
            }
            int left = 0, right = 0;
            for(int i = 1; i < n+1; i++){
                int j = i % 2;
                if(arr[i] != j){
                    if(j == 0){
                        left++;
                    }else{
                        right++;
                    }
                }
            }
            if(left != right){
                System.out.println(-1);
            }else{
                System.out.println(left);
            }
        }
    }
}
