package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个无重复正整数数组candidates和target，找出candidates中所有可以使数字和为target的组合。
 * candidates 中的数字可以无限制重复被选取。
 * @author: 文琛
 * @time: 2020/6/19 11:08
 */
public class lc39_和为target的组合 {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    //还是组合的套路，不过添加了一个求和限制
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target == 0)
            return lists;
        boolean[] used = new boolean[candidates.length];
        List<Integer> list = new ArrayList<>();
        return method(candidates, target, list, used, lists);
    }

    private static List<List<Integer>> method(int[] candidates, int target, List<Integer> list, boolean[] used, List<List<Integer>> lists) {
        if(target == 0){
            List<Integer> l = new ArrayList<>(list);
            lists.add(l);
        }
        int index = used.length-1;
        while(index > 0 && !used[index]){
            index--;
        }
        for(int i = index; i < used.length; i++){
            if(target >= candidates[i]){
                list.add(candidates[i]);
                used[i] = true;
                method(candidates, target - candidates[i], list, used, lists);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
        return lists;
    }
}
