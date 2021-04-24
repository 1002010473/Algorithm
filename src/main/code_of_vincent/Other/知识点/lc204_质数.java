package Other.知识点;

import java.util.Arrays;

/**
 * @description: 统计所有小于非负整数 n 的质数的数量。
 * n = 10, res = 4; --- 2 3 5 7
 * @author: 文琛
 * @time: 2020/8/18 9:13
 */
public class lc204_质数 {
    //XXX筛选法 -- 质数的倍数不是质数 -- 空间换时间
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {//此处遍历到sqrt(n)即可
            if(isPrim[i]){
                for(int j = i * i; j < n; j += i){//此处从i^2开始，具体见题解
                    isPrim[j] = false;
                }
            }//在循环过程中，已经将非质数的倍数也置为false;所以无需额外处理
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i])
                count++;
        }
        return count;
    }
}
