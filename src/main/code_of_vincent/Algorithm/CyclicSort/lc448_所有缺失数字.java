package Algorithm.CyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 该题是找缺失的数字--lc442：找重复的数字
 * @author: 文琛
 * @time: 2020/6/29 21:44
 */
public class lc448_所有缺失数字 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);
        for(int i : list){
            System.out.print(i + " ");
        }
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            //和286相比，不需要考虑0，但需要考虑重复元素，所以不能从i这个角度考虑，而是应该从nums[i]位置上出发考虑
            while(nums[nums[i]-1] != nums[i]){
                //ps:i位置上的元素变换会影响nums[i]-1的定位，所以顺序不能反
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                list.add(i+1);
            }
        }
        return list;
    }
}
