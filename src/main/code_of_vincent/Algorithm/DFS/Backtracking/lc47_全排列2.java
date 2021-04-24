package Algorithm.DFS.Backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 含有相同元素的全排列，不能重复排列
 * @author: 文琛
 * @time: 2020/6/19 9:44
 * 借鉴思路：重复元素必须按照先后顺序进入到排列当中，至于实现，就是如何控制元素按序插入的问题：排序，将重复元素放置到一起
 */
public class lc47_全排列2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return lists;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        return method(nums, list, lists, used);
    }

    private static List<List<Integer>> method(
            int[] nums, List<Integer> list, List<List<Integer>> lists, boolean[] used) {
        if(list.size() == nums.length){
            List<Integer> l = new ArrayList<>(list);
            lists.add(l);
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                if(i > 0 && (nums[i] == nums[i-1]) && !used[i-1]){ //在每个方法内，遍历过程中只会出现一次重复元素

                }else{
                    list.add(nums[i]);
                    used[i] = true;
                    method(nums, list, lists, used);
                    used[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }
        return lists;
    }
}
