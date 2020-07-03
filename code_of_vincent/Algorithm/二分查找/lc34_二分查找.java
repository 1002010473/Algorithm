package Algorithm.二分查找;

import org.junit.Test;

/**
 * @description: 常规查找--查找重复元素的最左边索引 查找重复元素的最右边索引
 *
 * 三个点：
 * 1、 left和right的初始化值-- 0->length-1  || 0->length
 * 2、while的判断条件
 * 3、赋值语句
 *  a：right的赋值表达式为 right = mid，那么循环条件也就只能使用 left < right （理解：right=mid容易在left = right 时出现死循环）
 *  b：1 和 2 的搭配使用方法需要根据条件要求来吧，一般是 length-1，然后while语句为 left<=right（根据退出循环的条件及a来进行判断）
 *
 *左右边界的查找实现的验证  lc 34
 *
 * @author: 文琛
 * @time: 2020/2/21 17:18
 */
public class lc34_二分查找 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6};
        System.out.println(search_a(arr, 3)); // 二分查找
        System.out.println(left_bound(arr, 1)); //新版左边界查找
        System.out.println(right_bound(arr, 6)); //新版右边界查找
    }

    public static int search_a(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //右边界查找  -- 分析见leetcode 740 相关题解
    //另：lc 744
    static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; //闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 查找右边界---> 收缩左边界（在 <= 的循环当中，不能出现相等的赋值操作？）
                left = mid + 1;
            }
        }
        // 检查
        // 退出循环的条件：left > right
        // 当target比所有元素都小时，right 会被减到 -1
        // 当target比所有元素都大时，left 会被加到 nums.length, right = length-1
        // 当数组中还没有target
        if (right < 0 || nums[right] != target)
            return -1;
        //有个问题，如果是没有target，那么right必然落到小于target的首个元素的位置上!!!!!
        //left也必然落在target+1的位置上
        //可以借助这个特点，查找对应结果--lc378
        return right;
    }

    //左边界查找  -- 分析见leetcode相关题解
    static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                //查找左边界：缩小右边界
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    @Test
    public void test(){
        int[] nums = {1, 2, 3, 5, 6, 7, 8};
        int target = 4;
        int left = 0, right = nums.length - 1; //闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 查找右边界---> 收缩左边界（在 <= 的循环当中，不能出现相等的赋值操作？）
                left = mid + 1;
            }
        }
        System.out.println(right);
        System.out.println(left);

    }
}
