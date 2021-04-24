package Algorithm.binary_search.acceleration;

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
        while(left < right){
            int mid = left + ((right - left) >> 1);
            int end = matrix[mid][n-1];
            if(target < end){
                right = mid;
            }else if(target > end){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return method(matrix,target,left);
    }
    public boolean method(int[][] matrix, int target, int m){
        int left = 0, right = matrix[0].length-1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
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
