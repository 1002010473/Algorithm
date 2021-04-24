package test.a;

import java.util.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/1 19:46
 */
public class Main {
    static int max;
    //后序暂无实现思路
    public static void main(String[] args) {
        System.gc();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr  = new int[1][1];

        ArrayList<Node> nodes = new ArrayList<>();
        int res = 0;
        for(int i = 0; i < N; i++){
            int c = sc.nextInt();
            int v = sc.nextInt();
            if(c > 0 && v <= 0){

            }else if(c <= 0 && v > 0){
                M -= c;
                res += v;
            }else{
                nodes.add(new Node(c, v));
            }
        }
        //boolean[] flags = new boolean[nodes.size()];
        method( nodes, M, 0, 0);
        System.out.println(res + max);
    }

    private static void method(ArrayList<Node> nodes, int m, int i, int count) {
        max = Math.max(max, count);
        if(i < nodes.size()){
            if(m <= 0){
                //只能处理负c
                for(int index = i; index < nodes.size();index++){
                    Node n = nodes.get(index);
                    if(n.c < 0){
                        m -= n.c;
                        count += n.v;
                        method(nodes, m, index + 1, count);
                        m += n.c;
                        count -= n.v;
                    }
                }
            }else{
                //同时处理两种类型
                for(int index = i; index < nodes.size();index++){
                    Node n = nodes.get(index);
                    if(n.c < 0 || n.c <= m){
                        m -= n.c;
                        count += n.v;
                        method(nodes, m, index + 1, count);
                        m += n.c;
                        count -= n.v;
                    }
                }
            }
        }
    }
}
class Node{
    int c;
    int v;
    public Node(int c, int v){
        this.c = c;
        this.v = v;
    }
}
