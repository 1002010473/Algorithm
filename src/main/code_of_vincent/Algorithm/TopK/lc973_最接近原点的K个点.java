package Algorithm.TopK;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 还有On复杂度的解法，待完善
 * @author: 文琛
 * @time: 2020/7/4 9:13
 */
public class lc973_最接近原点的K个点 {
    public static void main(String[] args) {
        int[][] points = {{1,3}, {2,-2}};
        int[][] ints = kClosest(points, 1);
        for(int[] is : ints){
            for(int i : is){
                System.out.println(i);
            }
        }
    }
    //排序：按照平方和，时间复杂度 O n log n -- 更快
    public static int[][] kClosest1(int[][] points, int K) {
        int[][] res = new int[K][2];
        Arrays.sort(points, (a, b) -> ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1])));
        for(int i = 0; i < K; i++){
            res[i] = points[i];
        }
        return res;
    }
    //大根堆：大于K个就pop -- n个元素入堆，n log n
    public static int[][] kClosest(int[][] points, int K) {
        //放一维数组
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a,b) -> ((b[0] * b[0]) + (b[1] * b[1])) - ((a[0] * a[0]) + (a[1] * a[1])));
        for(int i = 0; i < points.length; i++){
            maxPQ.add(points[i]);
            if(maxPQ.size() > K){
                maxPQ.poll();
            }
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++){
            res[i] = maxPQ.poll();
        }
        return res;
    }
}
