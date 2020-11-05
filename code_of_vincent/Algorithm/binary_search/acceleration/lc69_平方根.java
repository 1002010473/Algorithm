package Algorithm.binary_search.acceleration;

/**
 * @description: 返回省去小数位的int
 * @author: 文琛
 * @time: 2020/7/14 10:04
 */
public class lc69_平方根 {
    public int mySqrt(int x) {
        if(x <= 1)
            return x;
        long left = 1, right = x - 1;
        while(left <= right){
            long mid = left + (right - left) / 2;
            //相当于查找左边界
            long tmp = mid * mid;
            if(tmp == x){
                return (int)mid;
            }else if(tmp < x){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        //如果没有 == ，那么left和right将来到各自对应的错位，此时的right必然就是result
        return (int)right;
    }
}
