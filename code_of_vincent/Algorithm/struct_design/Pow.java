package Algorithm.struct_design;

/**
 * @description: lc50 -- Pow(x, n)
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1]
 * @author: 文琛
 * @time: 2020/8/10 16:54
 */
public class Pow {
    //船新版本 -- 按照二进制的表示方法实现对应位置上的幂级数累乘
    public double myPow(double x, int n) {
        if(x == 0 || x == 1) return x;
        //n是32位有符号整数，其数值范围是[−2^31, 2^31 − 1],所以取反以后可能存在越界问题，通过long解决
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1)
                res *= x;
            x *= x;
            b = b >> 1;
        }
        return res;
    }

    //初始版本
    public double myPow1(double x, int n) {
        if(x == 0) return x;
        if(x == 1) return 1;
        if(n == 0) {
            return 1;
        }else if(n > 0){
            return method(x, n);
        }else {
            long a = n;
            double s = method(x, -a);
            return 1/s;
        }
    }
    public double method(double x, long n){
        //设置数组，index = i 意味着 x 的 2^i 次幂，从而可以实现快速乘法
        double[] assist = new double[32];
        assist[0] = x;
        long i = 1;
        int j = 0;
        double res = x;
        while(n >= 2 * i){
            res *= res;
            i *= 2;
            assist[++j] = res;
        }
        n -= i;
        while(n > 0){
            while(n < i){
                i /= 2;
                j--;
            }
            n -= i;
            res *= assist[j];
        }
        return res;
    }
}
