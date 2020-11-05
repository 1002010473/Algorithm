package test.jd;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/17 19:44
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while(i-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            int h = 0,l = 0;
            for(int j = 0; j < n; j++){
                String s = sc.next();
                char[] cs = s.toCharArray();
                for(int k = 0; k < m; k++){
                    char c = cs[k];
                    if(c == '#'){
                        arr[j][k] = -1;
                    }else if(c == 'S'){
                        h = j;
                        l = k;
                    }else if(c == 'E'){
                        arr[j][k] = 2;
                    }
                }
            }
            Deque<Integer> queue = new LinkedList<>();
            queue.addLast(h);
            queue.addLast(l);
            boolean flag = false;
            while(!queue.isEmpty()){
                int a = queue.removeFirst();
                int b = queue.removeFirst();
                if(a > -1 && a < n && b > -1 && b < m ){
                    if(arr[a][b] == 2){
                        flag = true;
                        break;
                    }
                    if(arr[a][b] == 0){
                        arr[a][b] = 1;
                        queue.addLast(a);
                        queue.addLast(b-1);
                        queue.addLast(a);
                        queue.addLast(b+1);
                        queue.addLast(a-1);
                        queue.addLast(b);
                        queue.addLast(a+1);
                        queue.addLast(b);
                    }
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
