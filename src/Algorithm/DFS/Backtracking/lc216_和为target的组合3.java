package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数
 * 并且每种组合中不存在重复的数字
 * 组合问题
 * @author: 文琛
 * @time: 2020/6/19 13:29
 */
public class lc216_和为target的组合3 {
    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        List<List<Integer>> lists = combinationSum3(k, n);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        if(k == 0 || n == 0)
            return lists;
        List<Integer> list = new ArrayList<>();
        boolean[] flags = new boolean[10];
        return method(k, n, list, lists,flags);
    }

    private static List<List<Integer>> method(int k, int n, List<Integer> list, List<List<Integer>> lists, boolean[] flags) {
        if(k == 0){
            if(n == 0){
                List<Integer> l = new ArrayList<>(list);
                lists.add(l);
            }
            return lists;
        }
        int index = 9;
        while(index > 0 && !flags[index]){
            index--;
        }
        for(int i = index + 1; i < 10; i++){
            if(n >= i){
                list.add(i);
                flags[i] = true;
                method(k-1, n-i, list,lists, flags);
                list.remove(list.size()-1);
                flags[i] = false;
            }
        }
        return lists;
    }
}
