package Algorithm.TwoPointers;

import javax.swing.*;
import java.util.*;

/**
 * @description: 首先想到的是尝试遍历所有的可能性 n * n * n,排除重复list的方法可通过sort后的相同元素判断排除
 * 双指针：还是有方法尝试的，总归是三个元素，先将数组sort，然后以某个元素为中间元素，那么通过左右指针的滑动来实现
 * 总和的有目的性的变动，以获取所有总和为0的所有可能性
 *
 * //关于 寻找两个元素的和的问题，是否双指针一定可以遍历所有的可能性
 * 以 左指针为例分析：
 * 0 2 3 4 6 7
 * 0 1 2 3 4 5
 * target == 8
 * left = 1， right = 4时满足需求
 * 此时，假设left恰好来到1（原sum小于target）
 * 此时，right两种可能性： 1 right在4及4的右边，此时必然可以来到4，找出该可能
 * 2：right在4的左边，原sum小于target，该处没问题
 * 但是，right必是从4左移到当前位置，那么right==4时，sum>target,
 * 由于left只能从左往右移动，那么right = 4 时，left上的数必然小于2，这时的sum>target就是不可能的事情了
 * @author: 文琛
 * @time: 2020/6/25 10:07
 */
public class lc15_三数之和 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        List<List<Integer>> lists = threeSum(nums);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    //跟977类似，从中间到两边的遍历请况比较复杂，应该从两边到中间进行实现
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null)
            return null;
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length < 3)
            return lists;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int head = nums[i];
            if(head > 0)
                break;
            if(i > 0 && head == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while(l < r){
                int n = head + nums[l] + nums[r];
                if(n == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(head);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while(r > 0 && nums[r] == nums[r-1]){
                        r--;
                    }
                    r--;
                }else if(n < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return lists;
    }

    //尝试将中间元素作为遍历点，边界控制复杂，并未能通过全部测试数据
    public static List<List<Integer>> threeSum1(int[] nums) {
        if(nums == null)
            return null;
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length < 3)
            return lists;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i++){
            int mid = nums[i];
            int l = i-1;
            int r = i+1;
            //0000情况的排除
            if(i > 1 && mid == nums[i-1]){
                if(nums[l] == nums[l-1] && nums[r] == nums[r-1])
                    continue;
            }
            //当左右还都可以朝外扩张时
            while(l >= 0 && r < nums.length){
                int n = mid + nums[l] + nums[r];
                if( n == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(mid);
                    list.add(nums[r]);
                    lists.add(list);
                    //排除相同元素
                    while(r < nums.length - 1 && nums[r+1] == nums[r]){
                        r++;
                    }
                    r++;
                }else if(n < 0){
                    r++;
                }else{
                    l--;
                }
            }
            if(r < nums.length){
                while(r < nums.length && (mid + nums[0] + nums[r]) < 0){
                    r++;
                    if(r < nums.length && (mid + nums[0] + nums[r]) == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[0]);
                        list.add(mid);
                        list.add(nums[r]);
                        lists.add(list);
                        break;
                    }
                }
            }
            if(l >= 0){
                while(l >= 0 && (mid + nums[nums.length-1] + nums[l]) > 0){
                    l--;
                    if(l >= 0 && (mid + nums[l] + nums[nums.length-1]) == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[nums.length-1]);
                        list.add(mid);
                        list.add(nums[l]);
                        lists.add(list);
                        break;
                    }
                }
            }

        }
        return lists;
    }
}
