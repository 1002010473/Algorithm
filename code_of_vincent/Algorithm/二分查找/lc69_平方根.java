package Algorithm.二分查找;

/**
 * @description:
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
        //分析最后情况，在left == right处相遇，那么根据tmp的情况出现三种选择，right适用其中两种情况
        return (int)right;
    }
}
