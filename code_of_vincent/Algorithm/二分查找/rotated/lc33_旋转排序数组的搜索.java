package Algorithm.二分查找.rotated;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/13 16:54
 */
public class lc33_旋转排序数组的搜索 {
    public static void main(String[] args) {
        /*int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(search(nums,8));*/
        //int[] a = {4,5,6,7,0,1,2};
        int[] a = {3,1};
        //System.out.println(search(a, 1));
    }

    //将153的思路拿来，数组分为左右两半，分别进行二分查找
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int len = nums.length;
        int index = findMaxIndex(nums);
        if(index == 0){
            return bisSearch(nums, 0, len-1, target);
        }
        if(target <= nums[index-1] && target >= nums[0]){
            return bisSearch(nums, 0, index-1, target);
        }else if (index <= len-1 && target >= nums[index] && target <= nums[len - 1]){
            return bisSearch(nums, index, len -1, target);
        }else{
            return -1;
        }
    }
    public static int findMaxIndex(int[] nums){
        int left = 0, right = nums.length -1;
        if(nums[right] > nums[left])
            return right;
        while(left < right){
            int mid = left + ((right - left) >>> 1);
            int num = nums[mid];
            if(num < nums[right]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public int bisSearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + ((right - left) >>> 1);
            int num = nums[mid];
            if(num == target){
                return mid;
            }else if (num < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    //直接在旋转的数组上进行查找 -- 较为复杂 ： 不推荐
    public static int search1(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int len = nums.length;
        int end = nums[len-1];
        int head = nums[0];
        if(target > end && target < head)
            return -1;
        int left = 0, right = len - 1;
        while(left <= right){
            //无法去除--不知为何
            if(target == nums[left])
                return left;
            if(target == nums[right])
                return right;
            int mid = left + ((right - left) >>> 1);
            int num = nums[mid];
            if(num == target)
                return mid;
            if(nums[left] < nums[right]){ //位于递增的序列,常规的二分查找-可将时间复杂度降低（可省略，下文实现考虑了正常情况）
                if(num < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
                continue;
            }
            //先增后减
            if(num > nums[left]){ // mid落在了前半部上
                if(target > num){
                    left = mid + 1;
                }else{
                    if(target > nums[left]){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
            }else if(num < nums[left]){ // mid落在了后半部上
                if(target < num){
                    right = mid - 1;
                }else{
                    if(target < nums[right]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
            }else{
                left = mid  + 1;
            }
        }
        return -1;
    }
}
