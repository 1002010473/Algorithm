package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 * @author: 文琛
 * @time: 2020/6/19 10:30
 */
public class lc77_组合 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> lists = combine(n, k);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    //双层遍历即可，内层遍历中只往后遍历，不往前
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if(k == 0 || n == 0)
            return lists;
        boolean[] used = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        return method(n, k, used, lists,list);
    }

    private static List<List<Integer>> method(int n, int k, boolean[] used, List<List<Integer>> lists, List<Integer> list) {
        if(list.size() == k){
            List<Integer> l = new ArrayList<>(list);
            lists.add(l);
        }
        //找到遍历到的最后边界
        int i = n;
        while(i > 0 && !used[i]){
            i--;
        }
        for(int j = i+1; j <= n; j++){
            list.add(j);
            used[j] = true;
            method(n, k, used, lists, list);
            list.remove(list.size()-1);
            used[j] = false;
        }
        return lists;
    }
}
