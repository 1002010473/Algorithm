package Algorithm.dynamic_programming;

import java.util.HashMap;

/**
 * @description: 给定一个非负整数数组和一个目标数S。对于数组中的任意一个整数，你都可以改变其正负号
    返回可以使最终数组和为目标数 S 的数组正负可能性的方法数。
 * @author: 文琛
 * @time: 2020/6/11 13:39
 * 素质三连
 */
public class lc494_目标和 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(method1(nums, target));
        System.out.println(method2(nums, target));
        System.out.println(method3(nums, target));
    }
    //数组非空
    //暴力递归：每个位置上要么正，要么负，遍历所有方案
    //通过
    private static int method1(int[] nums, int target) {
        return fun1(nums, target, 0);
    }
    //递归主体：以index开头的方案数
    private static int fun1(int[] nums, int target, int index) {
        //base case
        if(index == nums.length){
            if(target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        //递归
        int res = 0;
        res += fun1(nums, target - nums[index], index+1);
        res += fun1(nums, target + nums[index], index+1);
        return res;
    }
    //备忘：二维
    //题目中给定了数组元素非负，且总和<1000,限制了范围,但是target在递归过程中仍然可能超过1000呀
    //感觉还不如直接用hashmap来的实在
    //耗时缩短4倍
    //private static int[][] tab;
    private static HashMap<String, Integer> map;
    private static int method2(int[] nums, int target) {
        //初始化
        //tab = new int[nums.length+1][2000];
        map = new HashMap<>();
        return fun2(nums, target, 0);
    }

    private static int fun2(int[] nums, int target, int index) {
        //base case
        if(index == nums.length){
            if(target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        String s = target + "_" + index;
        if(map.containsKey(s))
            return map.get(s);
        int res = 0;
        res += fun2(nums, target - nums[index], index+1);
        res += fun2(nums, target + nums[index], index+1);
        map.put(s, res);
        return res;
    }
    //dp 范围不明，暂且放弃
    //（sum + S）/ 2 更方便
    private static int method3(int[] nums, int target) {
        return 0;
    }


}
