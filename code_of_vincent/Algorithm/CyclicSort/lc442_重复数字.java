package Algorithm.CyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/6/29 22:16
 */
public class lc442_重复数字 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates(nums);
        for(int i : list){
            System.out.print(i + " ");
        }
    }
    public static List<Integer> findDuplicates(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != nums[nums[i]-1]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                list.add(nums[i]);
            }
        }
        return list;
    }
}
