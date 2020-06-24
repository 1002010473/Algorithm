package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 长度<数组len的集合
 * @author: 文琛
 * @time: 2020/6/19 19:50
 */
public class lc78_子集 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for(List<Integer> list : subsets){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    //普通的组合套路上稍加改进即可：（不含重复元素）在长度到达阈值之前放入lists即可
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return lists;
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        return method(nums, list, lists, used);
    }

    private static List<List<Integer>> method(int[] nums, List<Integer> list, List<List<Integer>> lists, boolean[] used) {
        //进来就保存即可
        List<Integer> l = new ArrayList<>(list);
        lists.add(l);
        int index = nums.length-1;
        while(index >= 0 && !used[index]){
            index--;
        }
        for(int i = index + 1; i < nums.length; i++){
            used[i] = true;
            list.add(nums[i]);
            method(nums, list, lists, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
        return lists;
    }
}
