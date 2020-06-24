package Algorithm.dynamic_programming;

/**
 * @description:给定一个无序数组，求最长上升子序列的长度
 * 素质三联：暴力递归+备忘录+dp
 * @author: 文琛
 * @time: 2020/6/7 14:08
 */
public class lc300_最长递增子序列_不连续 {
    public static void main(String[] args) {
        int[] data = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(method1(data));
        System.out.println(method2(data));
        System.out.println(method3(data));
    }
    /*暴力递归：求给定数组的最长上升子序列，相当于求从data[i]开始的最长上升子序列长度的最大值，0位置上最大长度取决于
    后序数组中比data[0]要大的元素的最大长度+1
    验证超时
     */
    private static int method1(int[] data) {
        int res = 0;
        for(int i = 0; i < data.length; i++){
            res = Math.max(res, fun1(data, i));
        }
        return res;
    }
    //递归函数：返回以index开头（必选）的最长上升子序列的长度值
    private static int fun1(int[] data, int index) {
        int comp = data[index];
        int len = 0;
        for(int i = index; i < data.length ; i++){
            if(data[i] > comp)
                len = Math.max(len, fun1(data, i));
        }
        return len + 1;
    }
    //备忘录
    private static int[] tab;//i位置上放置以data[i]开头的最大长度
    private static int method2(int[] data) {
        tab = new int[data.length];
        int res = 0;
        for(int i = 0; i < data.length; i++){
            res = Math.max(res, fun2(data, i));
        }
        return res;
    }
    private static int fun2(int[] data, int index) {
        if(tab[index] > 0)
            return tab[index];
        int comp = data[index];
        int len = 0;
        for(int i = index; i < data.length ; i++){
            if(data[i] > comp)
                len = Math.max(len, fun2(data, i));
        }
        tab[index] = len + 1;
        return len + 1;
    }
    //dp:从底往上 O(n 2)
    private static int method3(int[] data) {
        int len = data.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        dp[len-1] = 1;
        int res = 1;
        for(int i = len - 2; i >= 0; i--){
            int maxlen = 0;
            for(int j = i + 1; j < len; j++){
                if(data[j] > data[i])
                    maxlen = Math.max(maxlen,dp[j]);
            }
            res = Math.max(res, maxlen+1);
            dp[i] = maxlen+1;
        }
        return res;
    }
    //此题仍可以继续优化为O(n log n)
}
