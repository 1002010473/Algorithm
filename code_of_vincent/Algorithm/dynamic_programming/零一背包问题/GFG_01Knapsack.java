package Algorithm.dynamic_programming.零一背包问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 *  given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 *  Also given an integer W which represents knapsack capacity,
 *  find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 *
 *  You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * @author: 文琛
 * @time: 2020/7/5 13:47
 * --改dp的思路不畅：W--limit需要++挨个计算吗
 */
public class GFG_01Knapsack {
    public static void main(String[] args) {
        int[] vals = {1,2,3};
        int[] ws = {4,5,1};
        tab = new int[3][5];
        for (int[] ints : tab) {
            Arrays.fill(ints, -1);
        }
        int i = method1(vals, ws, 0, 4);
        System.out.println(i);
    }
    //递归所有组合，寻找max -- 超时
    static int res;
    public static void method(int[] vals, int[] ws, int val, int index, int limit){
        if(limit == 0)
            return;
        if(index == vals.length){
            res = Math.max(res, val);
        }else{
            for(int i = index; i < vals.length; i++){
                if(limit >= ws[i]){
                    method(vals, ws, val + vals[i], i+1,limit - ws[i] );
                }
            }
        }

    }
    //递归：每个节点的情况分析 -- 超时
    public static int method(int[] vals, int[] ws, int index, int limit){
        //每个位置上只有 两种选择 - 要 ： 不要
        if(index == ws.length)
            return 0;
        int con = 0;
        if(limit >= ws[index])
            con = vals[index] + method(vals, ws, index+1, limit - ws[index]);
        int exc = method(vals, ws, index+1, limit);
        return Math.max(con, exc);
    }

    //备忘录：将index 和 limit 涉及的结果通过二维数组保存起来 -- 超时
    static int[][] tab;
    public static int method1(int[] vals, int[] ws, int index, int limit){
        //每个位置上只有 两种选择 - 要 ： 不要
        if(index == ws.length)
            return 0;
        if(tab[index][limit] >= 0)
            return tab[index][limit];
        int con = 0;
        if(limit >= ws[index])
            con = vals[index] + method1(vals, ws, index+1, limit - ws[index]);
        int exc = method1(vals, ws, index+1, limit);
        int res = Math.max(con, exc);
        tab[index][limit] = res;
        return res;
    }
    //dp -- 还是超时
    public static void main1 (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int W = sc.nextInt();
            int[] vals = new int[n];
            int[] ws = new int[n];
            for(int i = 0; i < n; i++){
                vals[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                ws[i] = sc.nextInt();
            }
            //开始处理
            int[][]tab = new int[n+1][W+1];
            for(int i = n; i >= 0; i--){
                for(int j = 0; j <= W; j++){
                    if(i == n || j == 0){
                        //tab[i][j] = 0;
                    }else{
                        int inc = 0;
                        if(j >= ws[i])
                            inc = vals[i] + tab[i+1][j - ws[i]];
                        tab[i][j] = Math.max(inc, tab[i+1][j]);
                    }
                }
            }
            int res = tab[0][W];
            System.out.println(res);
        }
    }
}
