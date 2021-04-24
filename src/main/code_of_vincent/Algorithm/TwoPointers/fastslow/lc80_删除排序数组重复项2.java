package Algorithm.twopointers.fastslow;

/**
 * @description:给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，
 * 返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 * @author: 文琛
 * @time: 2020/8/13 9:23
 */
public class lc80_删除排序数组重复项2 {
    public int removeDuplicates(int[] nums) {
        //快慢指针处理
        int len = nums.length;
        if(len < 3)
            return len;
        int index = 1;//将要覆盖的index
        int count = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] == nums[i - 1]){
                count++;
            }else{
                count = 1;
            }

            if(count < 3){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
