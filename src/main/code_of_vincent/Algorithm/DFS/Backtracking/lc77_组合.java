package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合 -- 组合中不能有重复元素
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
        List<Integer> list = new ArrayList<>();
        return method(n, k,1, lists,list);
    }

    private static List<List<Integer>> method(int n, int k, int index, List<List<Integer>> lists, List<Integer> list) {
        if(list.size() == k){
            List<Integer> l = new ArrayList<>(list);
            lists.add(l);
        }
        //找到遍历到的最后边界
        int i = index;
        for(int j = i; j <= n; j++){
            list.add(j);
            method(n, k,j + 1, lists, list);
            list.remove(list.size()-1);
        }
        return lists;
    }
}
