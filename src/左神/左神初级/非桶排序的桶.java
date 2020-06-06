package 左神.左神初级;

/**
 * @description:
 * 给定一个数组，在 O(n) 的时间复杂度下，找出该数组有序情况下，相邻元素间的最大Gap，不能使用非比较排序
 * 基于比较的排序的最小时间复杂度--O（log n），因此，不能先进行排序再累计更新最大差
 * 利用桶的概念进行非桶排序：
 * 1.循环遍历一遍，找出最大值，最小值，计算二者的差值
 * 2.根据最大差值，数组元素个数，划分数组元素个数+1个桶
 * 3.将元素依次放进桶内--记录 1 桶内是否放入过元素， 2.桶内max 3.桶内min
 * 4.循环更新gap--非空桶的最小值和前一个非空桶的最大值
 *
 * @author: 文琛
 * @time: 2020/2/19 21:27
 */
public class 非桶排序的桶 {
    public static int maxGap(int[] nums){
        if(nums==null || nums.length<2) return 0;

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        if(max==min) return 0;
        //0-N号桶的三个信息；
        boolean[] hasNum = new boolean[len+1];
        int[] mins = new int[len+1];
        int[] maxs = new int[len+1];
        int bid = 0;//当前数属于的桶的编号
        for(int i = 0; i < len; i++){
            bid = bucket(nums[i],len,min,max);
            mins[bid] = hasNum[bid] ? Math.min(nums[i],mins[bid]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(nums[i],maxs[bid]) : nums[i];
            hasNum[bid]=true;
        }
        int res = 0;
        int lastMax = maxs[0];
        //int i = 1;
        for(int i =1; i<=len;i++){
            if(hasNum[i]){
                res = Math.max(mins[i]-lastMax,res);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max){//计算num属于哪个桶
        return (int) ((int) (num-min)*len/(max-min));
    }

    public static void main(String[] args) {
        int[] arr = {3,5,4,9,1,8};
        int res = maxGap(arr);
        System.out.println(res);
    }
}
