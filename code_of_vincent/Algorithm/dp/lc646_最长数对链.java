package Algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以放在(a, b)后面。我们用这种形式来构造一个数对链。
 * 给定一个对数集合，找出能够形成的最长数对链的长度。不需要用到所有的数对，可以以任何顺序选择其中的一些数对来构造。
 * @author: 文琛
 * @time: 2020/6/10 14:05
 * 素质三连： 暴力递归 + 备忘录 + dp
 */
public class lc646_最长数对链 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{5,6},{3,4}};
        System.out.println(method1(arr));
        System.out.println(method2(arr));
        System.out.println(method3(arr));
        System.out.println(method4(arr));
    }
    //暴力递归：试
    private static int method1(int[][] arr) {
        int comp = Integer.MIN_VALUE;
        //返回长度
        return fun1(arr, comp);
    }
    //递归主体：返回comp为底的数对链长度
    private static int fun1(int[][] arr, int comp) {
        //没有base case
        int res = 0;
        //遍历，找到所有左边界>comp的数对
        for(int i = 0; i < arr.length; i++){
            if(arr[i][0] > comp){//代表可以附在数对链的后面
                res = Math.max(res, 1 + fun1(arr, arr[i][1]));
            }
        }
        return res;
    }
    //备忘录：自顶向下递归，自底向上写入
    //发生变动的参数范围较大，且不连续，数组并不合适，尝试hashmap
    private static HashMap<Integer, Integer> map;
    private static int method2(int[][] arr) {
        map = new HashMap<>();
        int comp = Integer.MIN_VALUE;
        //返回长度
        return fun2(arr, comp);
    }

    private static int fun2(int[][] arr, int comp) {
        int res = 0;
        if(map.containsKey(comp))
            return map.get(comp);
        //遍历，找到所有左边界>comp的数对
        for(int i = 0; i < arr.length; i++){
            if(arr[i][0] > comp){//代表可以附在数对链的后面
                res = Math.max(res, 1 + fun2(arr, arr[i][1]));
            }
        }
        map.put(comp, res);
        return res;
    }
    //动态规划：自底向上写入
    //map中 key ： 底线（右边界） value ： 底线后缀数对的个数
    private static int method3(int[][] arr) {
        //先将二维数组按照其子元素的右边界进行排序
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        //左边界小于右边界，如果b数对左边界比a数对右边界大，那么b的右边界也大于a的右边界，所以，考虑范围只需要在右边即可
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        map.put(arr[len-1][1],0);
        for(int i = arr.length-2; i >= 0; i--){
            map.put(arr[i][1], 0);
            for(int j = i+1; j < len; j++){
                if(arr[j][0] > arr[i][1]){
                    map.put(arr[i][1], map.get(arr[j][1])+1);
                    break;
                }

            }
        }
        return map.get(arr[0][1])+1;
    }
    //贪心算法：不就是排会场的题么，以右边界为依据，从左到右选取即可
    private static int method4(int[][] arr) {
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        //arr.length >= 1(给定条件)
        int res = 1;
        int end = arr[0][1];
        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] > end){
                res++;
                end = arr[i][1];
            }
        }
        return res;
    }

}
