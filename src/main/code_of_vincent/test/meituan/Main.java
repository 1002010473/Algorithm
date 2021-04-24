package test.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 11:13
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = 0; i < n; i++){
            res ^= sc.nextInt();
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j < i){
                    res ^= j;
                }else{
                    res ^= ( j % i);
                }

            }
        }
        System.out.println(res);
    }
}
