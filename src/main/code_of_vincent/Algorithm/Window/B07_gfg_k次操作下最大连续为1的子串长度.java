package Algorithm.window;

/**
 * @description: Given a binary array a[] and a number k,
 * we need to find length of he longest subsegment of ‘1’s possible by changing at most k ‘0’s.
 * 和上一题类似，更简单
 * @author: 文琛
 * @time: 2020/6/21 21:31
 */
public class B07_gfg_k次操作下最大连续为1的子串长度 {
    public static void main(String[] args) {
        //尝试使用滑动窗口，需要处理数据的输入问题
        int[] nums = {1,0,0,1,0,1,0,1};
        int k = 2;
        System.out.println(longestSubSeg(nums, k));
    }

    private static int longestSubSeg(int [] nums, int k){
        int res = 0;
        int count = 0;
        int l = 0, r = 0;
        while(r < nums.length){
            if(nums[r++] == 0)
                count++;
            while(count > k){
                if(nums[l++] == 0)
                    count--;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
