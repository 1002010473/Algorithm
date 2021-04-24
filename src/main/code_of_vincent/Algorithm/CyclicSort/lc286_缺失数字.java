package Algorithm.CyclicSort;

/**
 * @description: 套路问题，放弃异或解法（不通用）
 * @author: 文琛
 * @time: 2020/6/29 21:40
 */
public class lc286_缺失数字 {
    public static void main(String[] args) {
        int[] nums = {4,3,0,1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        //按照循环排序的思路，数组比较特殊，可以按照元素大小来确定index，从而不需要内层的遍历，将时间复杂度将为On
        //遍历一次，将i上放置i+1，空缺处将0补过去即可
        int l = nums.length;
        for(int i = 0; i < l; ++i) {
            //i上放置0，不管，跳过
            //i上放置的不是i+1，交换-目的：将i上元素放置到该在位置上==将元素都放置好以后，0没地方去，只能在缺失位置上
            while( nums[i] != 0 && nums[i] != i+1 ) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < l; ++i) {
            if(nums[i] == 0)
                return i + 1;
        }
        return 0;
    }
}
