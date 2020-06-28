package Algorithm.TwoPointers.Fast_SlowPointers;

import java.util.HashSet;

/**
 * @description: 最大的问题：如何证明循环过程中，n不会无限增大呢？
 * 见官方题解中的证明：在n = 999 时，开始出现 next == 243 ，小于当前值，
 * 当然，在n = 9、99时，是可以增大的
 * 那么，在999及更大的数字中，不可能越来越大，从而不会出现无限增大的请况
 * @author: 文琛
 * @time: 2020/6/28 14:23
 */
public class lc202_快乐数 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }
    //hashset:log n + n 空间
    public static boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            n = method(n);
            if(set.contains(n))
                return false;
            set.add(n);
        }
        return true;
    }

    private static int method(int n) {
        int res = 0;
        while(n > 0){
            int i = n % 10;
            res += (i * i);
            n /= 10;
        }
        return res;
    }
    //快慢指针：尝试将空间复杂度降低
    public static boolean isHappy(int n) {
        int quick = n;
        int slow = n;
        while(quick != 1){
            slow = method(slow);
            quick = method(method(quick));
            if(quick == slow && slow != 1)
                return false;
        }
        return true;
    }
}
