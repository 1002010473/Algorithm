package Algorithm.KWayMerge;

import java.util.PriorityQueue;

/**
 * @description: 将二维矩阵的每个一维数组看作一个有序数组
 * @author: 文琛
 * @time: 2020/7/5 9:53
 */
public class lc378_有序矩阵的第k小的元素 {
    //套lc23的模板，小根堆 while
    public int kthSmallest(int[][] matrix, int k) {
        // K Way Merge
        if(k == 1)
            return matrix[0][0];
        int n = matrix.length;
        if(k == n * n)
            return matrix[n-1][n-1];
        int num = 0;
        int res = 0;
        //小根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for(int i = 0; i < n; i++){
            pq.add(new int[]{i, 0});
        }
        while(num < k){
            int[] min = pq.poll();
            res = matrix[min[0]][min[1]];
            num ++;
            if(min[1] < n-1){
                min[1] = min[1]+1;
                pq.add(min);
            }
        }
        return res;
    }
}
