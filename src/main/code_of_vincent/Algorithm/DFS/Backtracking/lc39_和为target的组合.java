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


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList();
        method(lists, list, candidates, 0, target);
        return lists;
    }
    public static void method(List<List<Integer>> lists, List<Integer> list, int[] candidates, int index, int target){
        if(target == 0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(index == candidates.length)
            return;
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] <= target){ //这里必须加括号，不加则method会不受限制的进入
                list.add(candidates[i]);
                method(lists, list, candidates, i, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
