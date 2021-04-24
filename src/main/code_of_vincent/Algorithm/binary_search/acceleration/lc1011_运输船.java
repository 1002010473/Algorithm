package Algorithm.binary_search.acceleration;

/**
 * @description: 类似于吃香蕉问题，求的是给定范围内满足条件的最小需求
 * @author: 文琛
 * @time: 2020/6/20 15:23
 */
public class lc1011_运输船 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        int power = shipWithinDays(weights, D);
        System.out.println(power);
    }
    public static int shipWithinDays(int[] weights, int D) {
        int[] res = getMaxAndSum(weights);
        int l = res[0];
        int r = res[1];
        while(l < r){
            int mid = l + (r-l)/2;
            if(can(weights, D, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    private static boolean can(int[] weights, int D, int mid) {
        int count = 1;
        int rest = mid;
        for(int i = 0; i < weights.length; i++){
            if(rest >= weights[i]){
                rest -= weights[i];
            }else{
                rest = mid - weights[i];
                count++;
            }
        }
        return count <= D;
    }

    private static int[] getMaxAndSum(int[] weights) {
        int max = 0;
        int sum = 0;
        for(int i : weights){
            max = Math.max(max, i);
            sum += i;
        }
        return new int[]{max, sum};
    }


}
