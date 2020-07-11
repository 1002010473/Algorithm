package Algorithm.greedy;

/**
 * @description: 在遍历过程中，每一步都尽量少给糖，必须加的时候加一个，
 * 体现了贪心思想：在每次选择时，以局部最优为导向，而不考虑此次操作对以后操作的影响
 * @author: 文琛
 * @time: 2020/7/11 16:46
 */
public class lc135_分发糖果 {
    //将条件中的左右最大的条件拆分为 左、右两边 分别判断，更新其满足两边条件的最新值即可
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] nums = new int[len];
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i-1]){
                nums[i] = nums[i-1]+1;
            }
        }
        int res = len + nums[len - 1];
        for(int i = len - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                nums[i] = Math.max(nums[i+1]+1, nums[i]);
            }
            res += nums[i];
        }
        return res;
    }
}
