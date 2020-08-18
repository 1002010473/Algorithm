package test;

import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/17 9:29
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String s = sc.next();
            if(n == 0) break;
            int res = method(n);
            System.out.println(res);
        }
    }

    private static int method(int n) {
        if(n < 2) return 0;
        if(n == 2) return 1;
        int a = n / 3;
        int b = n % 3;
        return a + method(a + b);
    }
}
