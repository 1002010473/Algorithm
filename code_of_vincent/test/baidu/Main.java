package test.baidu;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/14 19:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //初始化
        ArrayList[] lists =  new ArrayList[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n ; i++){
            map.put(i, i);
            lists[i] = new ArrayList<>(i);
        }
        //处理语句
        for(int i = 0 ; i < m; i++){
            String s = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(s.equals("C")){
                //System.out.println("c");
                ArrayList<Integer> from = lists[a];
                ArrayList<Integer> to = lists[b];
                for(int f : from){
                    to.add(f);
                    map.put(f, b);
                }
                lists[a] = null;
            }else{
                //System.out.println("q");
                int f = map.get(a);
                int t = map.get(b);
                if(f == t){
                    ArrayList<Integer> list = lists[f];
                    int k = list.indexOf(a);
                    int j = list.indexOf(b);
                    System.out.println(Math.abs(k - j));
                }else{
                    System.out.println(-1);
                }
            }
        }
    }
}
