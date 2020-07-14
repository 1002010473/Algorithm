package Algorithm.二分查找;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/14 9:20
 */
public class lc74_二维连续有序矩阵的查找 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m-1;
        while(left <= right){
            if(left == right)
                return method(matrix,target,left);
            int mid = left + ((right - left) >>> 1);
            int end = matrix[mid][n-1];//为什么要和end相比呢？因为在二维矩阵的行数大于1的时候，肯定存在right = left+1
            //那么此时，如果和start（matrix[mid][0])相比，此时，left就要 == mid，这是要进入死循环的，所以进行了变动
            if(target < end){
                right = mid;//left == right 的情况已经被上述特判给拦截了，所以可以有
            }else if(target > end){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
    public boolean method(int[][] matrix, int target, int m){
        int left = 0, right = matrix[0].length-1;
        while(left <= right){
            int mid = left + ((right - left) >>> 1);
            int num = matrix[m][mid];
            if(num < target){
                left = mid + 1;
            }else if(num > target){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
