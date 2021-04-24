package Algorithm.Order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:两数之和，一个元素只可以使用一遍
 * hashmap：一遍过，为了返回数组index，所以需要将map的v中存储index
 * window：排除
 * @author: 文琛
 * @time: 2020/11/11 15:38
 */
public class lc1_TwoSum {
    //map一遍过
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(target - num)){
                return new int[]{i, map.get(target - num)};
            }else{
                map.put(num, i);
            }
        }
        return new int[0];
    }
    //window
    public int[] twoSum2(int[] nums, int target) {
        int[] ns = Arrays.copyOf(nums, nums.length);//数组数据顺序拷贝
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while(left < right){
            int l = nums[left], r = nums[right];
            int sum = l + r;
            if(sum < target){ //当sum < target,left++
                left++;
            }else if(sum > target){
                right--;
            }else{
                break;
            }
        }
        //为了避免在a,b相同时，使用重复位置上的元素，所以遍历顺序相反
        int a = nums[left], b = nums[right];
        for(int i = 0; i < nums.length; i++){
            if(ns[i] == a){
                a = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(ns[i] == b){
                b = i;
                break;
            }
        }
        return new int[]{a, b};
    }
}
