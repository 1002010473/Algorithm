package ToOffer.Fifty;

/**
 * @description:连续子数组的最大和
 * 思路：累加过程中出现数组和减小，则将前面的数组元素舍弃，但数组和的最大值仍需记录
 * @author: 文琛
 * @time: 2020/2/5 22:05
 */
public class FortyTwo {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        int sum = FindGreatestSumOfSubArray(arr);
        System.out.println(sum);
    }

    private static int FindGreatestSumOfSubArray(int[] arr) {
        if (arr==null||arr.length==0) return 0;
        int greatestSum = 0;
        int total = 0;
        //int preTotal = 0;
        for (int i =0;i<arr.length;i++){
            total = total+arr[i];
            if (total<0){
                total =0;
            }
            if (total>greatestSum){
                greatestSum = total;
            }

        }
        return greatestSum;
    }
}
