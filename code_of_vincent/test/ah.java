package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/27 10:43
 */
public class ah {
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
        for(int i = 0, j = 1; j < nums.length; j++){
            if(i == nums.length - 1){
                list.add(nums[i] + "");
                break;
            }
            if(nums[j] == nums[j - 1] + 1)
                continue;
            if(j == i + 1){
                list.add(nums[i] + "");
            }else{
                list.add(nums[i] + "->" + nums[j - 1]);
            }
            i = j;
        }
        return list;
    }
}
