package Algorithm.二分查找;

import java.util.Scanner;

/**
 * @description: Given an array， The problem is to find the maximum sum bitonic subarray.
 * A bitonic subarray is a subarray in which elements are first increasing and then decreasing.（严格）
 * A strictly increasing or strictly decreasing subarray is also considered as bitonic subarray.
 * Time Complexity of O(n) is required.
 * @author: 文琛
 * @time: 2020/7/3 15:52
 * 跟二分查找有个屁的关系
 */
public class GFG_最大山峰型子数组之和 {
    //常规做法，从前往后遍历，遇到新的上升转折点必须要更新count，一遍过
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            int len = sc.nextInt();
            int[] arr = new int[len];
            for(int i = 0; i < len; i++){
                arr[i] = sc.nextInt();
            }
            long max = arr[0];
            long count = arr[0];
            int flag = 0;
            for(int i = 1; i < len; i++){
                if(arr[i] < arr[i-1]){
                    flag = -1;
                }else if (arr[i] > arr[i-1]){
                    if(flag < 0){
                        count = arr[i-1];
                        flag = 1;
                    }
                }else{
                    count = 0;
                }
                count += arr[i];
                max = Math.max(max, count);
            }
            System.out.println(max);
        }
    }
    //变态做法：维护两个数组，上升数组和下降数组
    public static void main1 (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- > 0) {
            int n = s.nextInt();

            int[] pat = new int[n];
            long[] a = new long[n];
            long[] b = new long[n];

            for (int i=0; i<n; i++) {
                pat[i] = s.nextInt();
                a[i] = pat[i];
                b[i] = pat[i];
            }

            for (int i=1; i<n; i++)
                if (pat[i] > pat[i-1])
                    a[i] += a[i-1];

            for (int i=n-2; i>=0; i--)
                if (pat[i] > pat[i+1])
                    b[i] += b[i+1];

            long sum = 0;

            for (int i=0; i<n; i++)
                sum = Math.max(sum, a[i]+b[i]-pat[i]);

            System.out.println(sum);
        }
    }

}
