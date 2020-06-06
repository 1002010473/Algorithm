package Algorithm;
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
 *左右边界的查找实现的验证 将 lc 34
 *
 * @author: 文琛
 * @time: 2020/2/21 17:18
 */
public class 二分查找 {
    public static void main(String[] args){
        int[] arr = {1,2,3,3,3,3,3,3,3,4,5,6};
        System.out.println(search_a(arr,3)); // 二分查找
        System.out.println(left_bound(arr,1)); //新版左边界查找
        System.out.println(right_bound(arr,6)); //新版右边界查找
    }

    public static  int  search_a (int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
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
        // 如果除去上述两种情况，数组中还没有target
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    //左边界查找  -- 分析见leetcode相关题解
    static int left_bound(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else{
                //查找左边界：缩小右边界
                right = mid - 1;
            }
        }
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }



    /*//旧版边界查找，不推荐
    public static int findLeft(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            int mid = l + ((r-l)>>1);
            if(nums[mid] < target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        //r根本就没有移动过---数组内全部的元素都小于target，左边界不存在
        if(r==nums.length-1)
            return -1;
        //如果r==-1，那么意味着l没动过，两种可能性，一：数组的最小值就是target---通过 == 时 r = mid-1 实现，这是返回-1+1=0即可
        if(r==-1){
            //target小于最小值时，l不移动，r移动到-1停止
            if(nums[0]!=target) return -1;
        }
        return r+1; //左边界返回r+1  --联系 == 情况时 r的变动情况
    }
    public static int findRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int m = left + ((right-left)>>1);
            if(nums[m] <= target)
                left = m + 1;
            else
                right = m - 1;
        }
        //说明left没动过，全部的值都>target---target不存在数组中，右边界不存在
        if(left==0)
            return -1;
        //说明right没动过，两种可能，< 或者 = /// 如果存在等于，那么直接返回left-1即可
        if(left==nums.length){
            //如果一直小于，那么右边界也不存在
            if(nums[nums.length-1]!=target)
                return -1;
        }
        return left-1; //右边界返回left-1； --联系 == 情况时 left 的变动情况
    }*/
}
