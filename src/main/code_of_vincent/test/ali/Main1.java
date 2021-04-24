package test.ali;

import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/8 18:59
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        long res = 1;
        for(int i = 1; i < n; i++){
            res += n;
        }
        System.out.println(res);
    }
}
