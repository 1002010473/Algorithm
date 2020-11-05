package Algorithm.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 将有序数组转换为 -> 表示的区间段
 * @author: 文琛
 * @time: 2020/7/27 10:43
 */
public class 连续区间的简化表示 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,4,5,7};
        List<String> strings = summaryRanges(arr);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        //双指针
        int start = 0;
        while(start < nums.length){
            int pre = nums[start];
            int j = start;
            while(j + 1 < nums.length && nums[j + 1] == pre + 1){
                j++;
                pre = nums[j];
            }
            if(j != start){
                list.add(nums[start] + "->" + nums[j]);
            }else{
                list.add(nums[start] + "");
            }
            start = j + 1;
        }
        return list;
    }
}
