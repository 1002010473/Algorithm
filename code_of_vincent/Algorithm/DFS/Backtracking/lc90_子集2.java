package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。（较上题包含了重复元素）
 * 说明：解集不能包含重复的子集。
 * @author: 文琛
 * @time: 2020/6/19 20:08
 */
public class lc90_子集2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    //元素重复需要考虑进去
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return lists;
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
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
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){

            }else{
                used[i] = true;
                list.add(nums[i]);
                method(nums, list, lists, used);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
        return lists;
    }
}
