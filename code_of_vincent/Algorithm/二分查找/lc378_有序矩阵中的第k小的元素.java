package Algorithm.二分查找;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/3 17:26
 */
public class lc378_有序矩阵中的第k小的元素 {
    //维护一个等长度的一维数组，数组中存放的是行的index，遍历该数组获取最小的值，更新对应index
    //时间复杂度 Onk，通过
    public int kthSmallest(int[][] matrix, int k) {
        int[] tmp = new int[matrix.length];
        int i = 0;
        int res = 0;
        while(i < k){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0; j < tmp.length; j++){
                if(tmp[j] < matrix.length && matrix[tmp[j]][j] < min){
                    min = matrix[tmp[j]][j] ;
                    index = j;
                }
            }
            i++;
            res = min;
            tmp[index] ++;
        }
        return res;
    }
    //二分查找法：查找左边界(存在元素，小于等于其的元素个数正好为k)或者是大于k的第一个元素（不存在这样的元素）
    //method 返回矩阵中小于等于 medium 的元素个数
    public int kthSmallest1(int[][] matrix, int k) {
        //找左边界
        int n = matrix.length;
        int small = matrix[0][0];
        int big = matrix[n-1][n-1];
        while(small <= big){
            int mid = small + (big - small) / 2;
            int num = method(matrix, mid);
            if (num < k){
                small = mid + 1;
            }else{
                big = mid - 1;//不一定num正好等于k
            }
        }
        return small;
    }
    //判断方式：按照有序矩阵的查找方法，从左下角查起- On
    //因为按照这种查法，要么向上，要么向右，一遍即过
    public int method(int[][] matrix, int mid){
        int n = matrix.length;
        if(mid < matrix[0][0])
            return 0;
        if(mid > matrix[n-1][n-1])
            return n * n;
        int h = n-1;
        int l = 0;
        int res = 0;
        while(h >= 0 && l < n){
            while(h >= 0 && matrix[h][l] > mid){
                h--;
            }
            res += (h+1);
            l++;
        }
        return res;
    }
}
