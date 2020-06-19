package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 该题目中， 每个元素只能只用一次，只需要在上一题目中添加 改动即可
 * @author: 文琛
 * @time: 2020/6/19 12:56
 */
public class lc40_和为target的组合2 {
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

    //涉及到重复元素问题，需要采取排列类似的方法，将数组进行排序
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target == 0)
            return lists;
        Arrays.sort(candidates);
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
        while(index >= 0 && !used[index]){
            index--;
        }
        //较上一题目，此处应该从index对应的下一个处开始遍历，从而避免重复使用元素
        for(int i = index+1; i < used.length; i++){
            if(target >= candidates[i]){
                if(i>0 && candidates[i] == candidates[i-1] && !used[i-1]){

                }else{
                    list.add(candidates[i]);
                    used[i] = true;
                    method(candidates, target - candidates[i], list, used, lists);
                    list.remove(list.size()-1);
                    used[i] = false;
                }
            }
        }
        return lists;
    }
}
