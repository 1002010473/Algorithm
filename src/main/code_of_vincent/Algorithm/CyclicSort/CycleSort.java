package Algorithm.CyclicSort;
/**
 * @description: 一种On2时间复杂度的排序算法
 * @author: 文琛
 * @time: 2020/6/29 14:39
 */
public class CycleSort {
    public static void main(String[] args) {
        int[] nums = {8,4,2,6,8,4,9,11};
        cycleSort(nums);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
    //验证可行
    private static void cycleSort(int[] nums) {
        //遍历数组，依次将各个位置上的元素确定
        for(int i = 0; i < nums.length-1; i++){
            int now = nums[i];
            int pos = i;
            //内部遍历，寻找应该放置的位置
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < now)
                    pos++;
            }
            if(pos == i)
                continue;
            //重复元素依次后推
            while(nums[pos] == now){
                pos++;
            }
            //交换
            int tmp = nums[pos];
            nums[pos] = now;
            now = tmp;
            while(pos != i){
                pos = i;
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[j] < now)
                        pos++;
                }
                if(pos == i){
                    nums[i] = now;
                    break;
                }

                //重复元素依次后推
                while(nums[pos] == now){
                    pos++;
                }
                //交换
                int t = nums[pos];
                nums[pos] = now;
                now = t;
            }
        }
    }
}
