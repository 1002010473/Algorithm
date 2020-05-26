package sixty;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/13 21:38
 */
public class FiftyThree_3 {
    public int getNumberSameAsIndex(int[] nums,int start,int end){
        if (nums==null||nums.length==0){
            return -1;
        }
        while(end>=start){
            int middle = (start+end)/2;
            if (middle==nums[middle]){
                return middle;
            }else if(middle<nums[middle]){
                end=middle-1;
            }else{
                start=middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {0};
        FiftyThree_3 fiftyThree_3 = new FiftyThree_3();
        int result = fiftyThree_3.getNumberSameAsIndex(arr, 0, arr.length - 1);
        System.out.println(result);
    }
}
