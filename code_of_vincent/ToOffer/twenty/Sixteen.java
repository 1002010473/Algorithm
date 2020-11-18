package ToOffer.twenty;

import org.junit.Test;

/**
 * @description:double类型数值的int次方；
 * @author: 文琛
 * @time: 2019/12/1 14:16
 */
public class Sixteen {
    //递归解法
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            return 1.0 / method(x, -N);
        }else{
            return method(x, N);
        }
    }

    public double method(double x, long n){
        if(n == 0) return 1;
        double y = method(x, n >> 1);
        if((n & 1) == 1){
            return x * y * y;
        }else{
            return y * y;
        }
    }
    //迭代实现 -- 将n转换为二进制数，每个位置上的1加权相加即得结果
    public double myPow1(double x, int n) {
        if(x == 0 || x == 1) return x;
        long N = n;
        if(N < 0){
            N = - N;
            x = 1 / x;
        }
        double res = 1;
        while(N > 0){
            if((N & 1) == 1){
                res *= x;
            }
            x *= x;
            N = N >> 1;
        }
        return res;
    }
}
