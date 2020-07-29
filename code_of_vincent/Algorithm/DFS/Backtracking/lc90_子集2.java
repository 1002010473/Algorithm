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
    //元素重复需要考虑进去---每一层（for循环）不出现重复的元素即可
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return lists;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        return method(nums, list, lists, 0);
    }
    private static List<List<Integer>> method(int[] nums, List<Integer> list, List<List<Integer>> lists, int index) {
        //进来就保存即可
        List<Integer> l = new ArrayList<>(list);
        lists.add(l);
        for(int i = index; i < nums.length; i++){
            if(i == index || nums[i] != nums[i-1] ){
                list.add(nums[i]);
                method(nums, list, lists, i+1);
                list.remove(list.size()-1);
            }
        }
        return lists;
    }
}
