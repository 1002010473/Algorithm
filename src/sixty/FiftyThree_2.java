package sixty;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/13 21:28
 */
public class FiftyThree_2 {
    public int missingNumber(int[] nums) {
        int length  =  nums.length;
        int missingNum = find(nums,0,length-1);
        return missingNum;
    }
    public int find(int[] nums,int start,int end){
        if(nums==null|nums.length==0){
            return -1;
        }
        while(start<=end){
            int middle= (start+end)/2;
            //如果middle处的index和值不相同，且middle之前一位的相同（middle>0)，那么返回该index；
            if(nums[middle]!=middle&&middle>0&&nums[middle-1]==middle-1){
                return middle;
            }else if(nums[middle]!=middle){
                if(middle>start){
                    end=middle-1;
                }else{
                    return middle;
                }

            }
            if(nums[middle]==middle){
                if(middle==nums.length-1){
                    return nums.length;
                }else {
                    start=middle+1;
                }

            }
        }
        return -1;
    }
}
