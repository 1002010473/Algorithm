package Algorithm.dp;

/**
 * @description:数组，相邻元素不能同时盗窃，求盗窃的最大金额
 * @author: 文琛
 * @time: 2020/6/8 10:10
 * 尝试素质三连：暴力递归 + 备忘录 + dp
 */
public class lc198_打家劫舍_1 {
    public static void main(String[] args) {
        int[] arr  = new int[]{2,7,9,3,1};
        System.out.println(rob1(arr));
        System.out.println(rob2(arr));
        System.out.println(rob3(arr));
        System.out.println(rob4(arr));
        System.out.println(rob5(arr));
        System.out.println(rob6(arr));
    }
    //两个版本：1

    //暴力递归：数组中都是正整数，所以，起始位置必然是前两位，get到前两位的max即可
    //假设处于cur位置，cur的最大值 = cur+2 ， cur+3 的最大值 + cur的值
    //超时
    private static int rob1(int[] arr) {
        int zero = method1(arr, 0);
        int one = method1(arr, 1);
        return Math.max(zero, one);
    }
    //递归主体：返回以index为起始位置(确定盗窃该位置)的盗窃最大值
    private static int method1(int[] arr, int index) {
        int len = arr.length;
        //base case :当cur处于末尾两个位置时，直接返回cur对应的值即可
        if(index > len - 3)
            return arr[index];
        int pre = 0,aft = 0;
        if(index + 2 < len){
            pre = method1(arr, index+2);
        }
        if(index + 3 < len){
            aft = method1(arr, index+3);
        }
        return Math.max(pre, aft) + arr[index];
    }
    //备忘录：自顶向下递归，自下向上写入
    //超时，但有提升
    private static int[] tab;
    private static int rob2(int[] arr) {
        int len = arr.length;
        tab = new int[len];
        int zero = method2(arr, 0);
        int one = method2(arr, 1);
        return Math.max(zero, one);
    }

    private static int method2(int[] arr, int index) {
        int len = arr.length;
        //base case :当cur处于末尾两个位置时，直接返回cur对应的值即可
        if(index > len - 3)
            return arr[index];
        if(tab[index] > 0)
            return tab[index];
        int pre = 0,aft = 0;
        if(index + 2 < len){
            pre = method2(arr, index+2);
        }
        if(index + 3 < len){
            aft = method2(arr, index+3);
        }
        tab[index] = Math.max(pre, aft) + arr[index];
        return tab[index];
    }
    //dp:刨除递归，自底向上
    //dp[i]代表含义：以i开头的打劫最大值
    private static int rob3(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[len-1] = arr[len-1];
        dp[len-2] = arr[len-2];
        //较递归多考虑一步到len-3，因为只有len-3才会依赖到outofindex，这样可以避免在遍历中添加额外的防越界逻辑
        dp[len-3] = arr[len-3] + arr[len-1];
        for(int i = len - 4; i >= 0; i--){
            dp[i] = Math.max(dp[i+2],dp[i+3]) + arr[i];
        }
        return Math.max(dp[0], dp[1]);
    }

    //两个版本：2(better)
    //暴力递归: cur是否盗窃取决于两种情况：盗窃cur+1更大，盗窃cur更大
    private static int rob4(int[] arr) {//忽略边界情况
        return method4(arr, 0);
    }
    //递归主体：返回以index为开头范围内的盗窃最大值（不是必须盗窃index）
    private static int method4(int[] arr, int index) {
        if(index >= arr.length)
            return 0;
        return Math.max(method4(arr, index+1), arr[index] + method4(arr, index + 2));
    }

    private static int rob5(int[] arr) {
        return 0;
    }

    private static int rob6(int[] arr) {
        return 0;
    }



}
