package Algorithm.binary_search.kth;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/12 19:09
 */
public class lc668_乘法表中第k小的数 {
    public int findKthNumber(int m, int n, int k) {
        //大致思路--按照二分查找的方法进行遍历寻找
        if(k == m * n || k == 1)
            return k;
        int left = 1, right = m * n;
        while(left <= right){ //寻找左边界
            int mid = left + ((right - left) >>> 1);
            int count = method(m, n, mid);
            if(count < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public int method(int m, int n, int mid){
        int hight = m, res = 0;
        for(int i = 1; i <= n; i++){
            while(mid < i * hight){
                hight--;
            }
            if(hight <= 0)
                break;
            res += hight;
        }
        return res;
    }
}
