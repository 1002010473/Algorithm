package Algorithm.dp.背包问题;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/8 17:14
 */
public class lc813_最大平均值和的分组 {
    //超时
    public double largestSumOfAverages(int[] A, int K) {
        //奇奇怪怪 -- 从dp推到递归
        return method(A, K, 0);
    }
    public double method(int[] A, int K, int index){
        int len = A.length;
        if(K == 1)
            return help(A, index, A.length-1);
        double res = 0;
        for(int i = index+1; (len - i) >= K-1; i++){
            double j = method(A, K-1, i);
            double curAve = help(A, index, i-1);
            res = Math.max(res, j + curAve);
        }
        return res;
    }
    public double help(int[] A, int start, int end){
        double sum = 0; // 必须double，不然出错，可能存在越界问题
        for(int i = start; i <= end; i++){
            sum += A[i];
        }
        return sum / (end - start + 1);
    }
    //备忘录 -- dp待做，思路太绕了，难顶
    double[][] tab;
    public double largestSumOfAverages1(int[] A, int K) {
        //奇奇怪怪 -- 从dp推到递归
        tab = new double[K+1][A.length];
        return method1(A, K, 0, tab);
    }

    public double method1(int[] A, int K, int index, double[][] tab){
        int len = A.length;
        if(K == 1)
            return help(A, index, A.length-1);
        if(tab[K][index] > 0)
            return tab[K][index];
        double res = 0;
        for(int i = index+1; (len - i) >= K-1; i++){
            double j = method1(A, K-1, i, tab);
            double curAve = help(A, index, i-1);
            res = Math.max(res, j + curAve);
        }
        tab[K][index] = res;
        return res;
    }

}
