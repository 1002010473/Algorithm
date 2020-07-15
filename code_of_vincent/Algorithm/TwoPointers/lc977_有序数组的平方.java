package Algorithm.twopointers;

/**
 * @description: 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * @author: 文琛
 * @time: 2020/6/25 9:38
 * 问题的本质：寻找最大/最小的绝对值即可
 * 最小绝对值需要遍历数组查找，但是最大绝对值必然在两端，所以，这样从两端向中间汇合更合适
 */
public class lc977_有序数组的平方 {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int[] res = sortedSquares(nums);
        for(int i : res){
            System.out.println(i);
        }
    }
    //双指针即可
    public static int[] sortedSquares(int[] A) {
        //双指针
        int[] ans = new int[A.length];
        int left = 0;
        int right = A.length-1;
        int index = right;
        while(left<=right){
            if(Math.abs(A[left])<=Math.abs(A[right])){
                ans[index--] = A[right]*A[right--];
            }else{
                ans[index--] = A[left]*A[left++];
            }
        }
        return ans;
    }
}
