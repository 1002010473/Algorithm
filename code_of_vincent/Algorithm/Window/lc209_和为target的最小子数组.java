package Algorithm.window;

/**
 * @description: 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * @author: 文琛
 * @time: 2020/6/21 14:44
 */
public class lc209_和为target的最小子数组 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println(minSubArrayLen(s, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        //滑动窗口即可（元素>0， 连续子数组），每个index作为left都会遍历
        if(nums == null || nums.length == 0 || s == 0)
            return 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        //r作为外层循环的判断条件，l作为内层的影响因素 -- 如果需要在len-1加到结果中后进行操作判断，此时应该进行如下操作
        //步步为营 -- 每个节点添加进去
        //一直循环 -- 将左边界放入到循环当中去
        while(r < nums.length){
            sum += nums[r++];
            while(sum >= s){
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0 || s == 0)
            return 0;
        int l = 0;
        int r = 0; //下一个即将加入的边界
        int sum = 0;
        int res = Integer.MAX_VALUE;
        //复杂实现
        while(r < nums.length || sum > s){ //当len-1的元素放入到sum中后，此时的r == length;直接结束了循环，不再走l++
            //需要在r = len 时，为后序的操作打开一条通道 -- 这种情况出现在求最短方面的操作上
            if(sum < s){
                sum += nums[r++];
            }else{
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
