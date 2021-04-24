package Algorithm.twopointers.seq.target;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/15 11:36
 */
public class lc18_四数之和 {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if(len < 4) return lists;
        Arrays.sort(nums);
        for(int i = 0; i < len - 3; i++){
            if(nums[i] > 0 && nums[i] > target)  break;
            int a = nums[i];
            for(int j = i + 1; j < len - 2; j++){
                int b = nums[j];
                int left = j + 1;
                int right = len - 1;
                while(left < right){
                    int sum = a + b + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        while(right > left && nums[right - 1] == nums[right]){
                            right--;
                        }
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
                while(j < (len - 2) && nums[j+1] == b){
                    j++;
                }
            }
            while(i < (len - 3) && a == nums[i+1]){
                i++;
            }
        }
        return lists;
    }
}
