package Algorithm.二分查找;

/**
 * @description: 二分查找进行加速遍历所有的速度可能 （上下限都已知）
 * @author: 文琛
 * @time: 2020/6/20 15:03
 */
public class lc875_爱吃香蕉的珂珂 {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int H = 8;
        int speed = minEatingSpeed(piles, H);
        System.out.println(speed);
    }

    public static int minEatingSpeed(int[] piles, int H) {
        //首先排除特殊情况
        int len = piles.length;
        int max = max(piles);
        if(H == len)
            return max;
        //二分查找的嵌入
        int l = 1;
        int r = max;
        //寻找左边界
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(canFinish(piles, mid, H)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    private static boolean canFinish(int[] piles, int mid, int H) {
        int count = 0;
        for(int i : piles){
            int k = i / mid;
            int j = i % mid;
            count += k;
            count += (j == 0 ? 0 : 1);
        }
        return count <= H;
    }

    private static int max(int[] piles) {
        int max = 0;
        for(int i : piles){
            max = Math.max(max, i);
        }
        return max;
    }
}
