package Algorithm.dp;

/**
 * @description:思路：相比于123，1234结尾处增加了一个等差元素，以4结尾等差数组的数量为以3结尾的数量＋1
 * @author: 文琛
 * @time: 2020/6/8 14:22
 * 尝试进行素质三连： 暴力递归 + 备忘录 + dp
 */
public class lc413_等差数列数目统计 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(method1(arr));
        System.out.println(method2(arr));
        System.out.println(method3(arr));
    }

    //暴力递归：从尾部开始遍历进行推算，默认长度大于等于3
    private static int method1(int[] arr) {
        int res = 0;
        for(int i = 2; i < arr.length; i++){
            res += fun1(arr,i);
        }
        return res;
    }
    //递归主体：传入index，返回index位置为结尾的等差数列总数
    private static int fun1(int[] arr, int index) {
        //不那么清晰的base case
        if(index < 2)
            return 0;
        if((arr[index] - arr[index-1]) != (arr[index-1] - arr[index-2])){
            return 0;//如果不能等差连续，该位置相当于==0
        }else{
            return fun1(arr, index-1) + 1;
        }
    }
    //备忘录：自顶向下递归，自底向上写入index相关计算结果
    private static int[] tab; //tab[i]意味着以arr[i]结尾的数组等差数列个数
    private static int method2(int[] arr) {
        tab = new int[arr.length];
        int res = 0;
        for(int i = 2; i < arr.length; i++){
            res += fun2(arr,i);
        }
        return res;
    }
    private static int fun2(int[] arr, int index) {
        if(index < 2)
            return 0;
        if(tab[index] > 0)
            return tab[index];
        if((arr[index] - arr[index-1]) != (arr[index-1] - arr[index-2])){
            return 0;//如果不能等差连续，该位置相当于==0
        }else{
            return fun2(arr, index-1) + 1;
        }
    }
    //dp
    private static int method3(int[] arr) {
        int[] dp = new int[arr.length];
        int res = 0;
        for(int i = 2; i < arr.length; i++){
            if((arr[i] - arr[i-1]) == (arr[i-1] - arr[i-2])){
                dp[i] = dp[i-1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
