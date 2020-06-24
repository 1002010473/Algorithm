package Algorithm.Window;

import java.util.Scanner;

/**
 * @description: 给定一个数组和一个长度K，找到数组中K长度子串的最大和--easy
 * @author: 文琛
 * Input:
 * 2
 * 4 2
 * 100 200 300 400
 * 9 4
 * 1 4 2 10 23 3 1 0 20
 * Output:
 * 700
 * 39
 * @time: 2020/6/21 14:25
 */
public class B01_MaxSumSubarrayofSizeK {
    public static void main (String[] args) {
        //code
        //尝试使用滑动窗口，需要处理数据的输入问题
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T > 0){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] nums = new int[N];
            for(int i = 0; i < N; i++){
                nums[i] = sc.nextInt();
            }
            if(K > N)
                System.out.println("K is too big");
            int sum = 0;
            for(int i = 0; i < K; i++){
                sum += nums[i];
            }
            int res = sum;
            for(int j = K; j < N; j++){
                sum -= nums[j-K];
                sum += nums[j];
                res = Math.max(sum, res);
            }
            System.out.println(res);
            T--;
        }
    }

}
