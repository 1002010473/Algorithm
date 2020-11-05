package test.a;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 19:40
 */
public class Ali002 {

    public static void main(String[] args) {
        int n, m, x, y , k1, k2;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] par = new int[n+1];
        par[1] = 1;
        for (int i = 2; i <= n; i++) {
            par[i] = scanner.nextInt();
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (m-->0) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            k1 = x; k2 = y;
            s1.clear(); s2.clear();
            s1.push(x); s2.push(y);
            while (par[x] != x) {
                x = par[x];
                s1.push(x);
            }
            while (par[y] != y) {
                y = par[y];
                s2.push(y);
            }
            int parent = 1;
            while (!s1.empty() && !s2.empty()){
                int a = s1.pop();
                int b = s2.pop();
                if (a==b) {
                    parent = a;
                    break;
                }
            }
            int lena = 0;
            int lenb = 0;
            while (k1!=parent){
                k1 = par[k1];
                lena++;
            }
            while (k2!=parent){
                k2 = par[k2];
                lenb++;
            }
            //System.out.println(lena+"/"+ lenb);
            if (lena<=lenb){
                System.out.println("A");
            }else{
                System.out.println("B");
            }
        }
    }
}
