package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 全排列
 * @author: 文琛
 * @time: 2020/6/18 16:22
 */
public class lc46_全排列 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        for(List<Integer> list : permute){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return lists;
        boolean[] flags = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        return method(nums, flags, list, lists);
    }

    private static List<List<Integer>> method(int[] nums, boolean[] flags, List<Integer> list, List<List<Integer>> lists) {
        if(list.size() == nums.length){
            List<Integer> l = new ArrayList<>(list);
            lists.add(l);
        }else{
            for(int i = 0; i < nums.length; i++){
                if(!flags[i]){
                    list.add(nums[i]);
                    flags[i] = true;
                    method(nums, flags, list, lists);
                    list.remove(list.size()-1);
                    flags[i] = false;
                }
            }
        }
        return lists;
    }
}
