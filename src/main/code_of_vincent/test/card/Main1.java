package test.card;

import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/21 19:28
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[1001];
            while(n-- > 0){
                int k = sc.nextInt();
                arr[k]++;
            }
            int res1 = 0, res2 = 0;
            for(int i = 1; i < 1001; i++){
                while(arr[i] >= 4){
                    res1 += 1;
                    arr[i] -= 4;
                }
                if(arr[i] >= 2){
                    res2 += 2;
                }
            }
            System.out.println(res1 + " " + (res2 / 4));
        }
    }
}
