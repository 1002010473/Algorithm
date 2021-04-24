package Algorithm.dp.背包问题;

/**
 * @description: 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 * 分割为两个子集，且两个子集 的元素和相等，那么算出总和之后对半分即可，问题就变成了是否可以在数组中凑出half
 * @author: 文琛
 * @time: 2020/6/11 10:08
 * 尝试素质三连：暴力递归 + 备忘 + dp
 */
public class lc416_分割等和子集 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,11,5,3};
        System.out.println(method1(arr));
        System.out.println(method2(arr));
        System.out.println(method3(arr));
    }
    //暴力递归：试（选择 + 状态）每个元素只有两种状态供选择，1 or 2 -- 很巧妙哦，只需要凑出来half即可
    //超时
    private static boolean method1(int[] arr) {
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        if(sum % 2 == 1)
            return false;
        int half = sum / 2;
        return fun1(arr, 0, half);
    }
    private static boolean fun1(int[] arr, int index, int half) {
        if(half == 0)
            return true;
        if(index == arr.length)
            return false;
        return fun1(arr, index+1, half) || fun1(arr, index+1, half - arr[index]);
    }

    //备忘：首先尝试二维数组 0：代表无 1：代表false 2：代表true
    static int[][] tab;
    private static boolean method2(int[] arr) {
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        if(sum % 2 == 1) return false;
        int half = sum / 2;
        tab = new int[arr.length][half+1];
        return fun2(arr, 0, half);
    }

    private static boolean fun2(int[] arr, int index, int half) {
        if(half < 0)
            return false;
        if(half == 0)
            return true;
        if(index == arr.length)
            return false;
        if(tab[index][half] == 1){
            return false;
        }else if (tab[index][half] == 2){
            return true;
        }
        boolean flag = fun2(arr, index+1, half) || fun2(arr, index+1, half - arr[index]);
        if(flag){
            tab[index][half] = 2;
        }else{
            tab[index][half] = 1;
        }
        return flag;
    }
    //dp --
    private static boolean method3(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1) return false;
        int half = sum / 2;
        boolean[][] dp = new boolean[nums.length][half+1];
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        for(int i = nums.length-2; i >= 0; i--){
            for(int j = 1; j <= half; j++){
                if(j-nums[i] < 0){
                    dp[i][j] = dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j] || dp[i+1][j-nums[i]];
                }
            }
        }
        return dp[0][half];
    }
    //dp：尝试改为一维数组
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1)
            return false;
        int half = sum / 2;
        boolean[] dp = new boolean[half+1];
        dp[0] = true;
        if(nums[nums.length-1] <= half)
            dp[nums[nums.length-1]] = true;
        for(int i = nums.length-2; i >= 0; i--){
            for(int j = half; j >= nums[i]; j--){ // 注意边界
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[half];
    }
}
