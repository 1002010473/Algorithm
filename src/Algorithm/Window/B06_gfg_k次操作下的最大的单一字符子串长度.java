package Algorithm.Window;

import java.util.Scanner;

/**
 * @description: We have a string of length n, which consist only UPPER and LOWER CASE characters
 * and we have a number k (always less than n and greater than 0).
 * We can make at most k changes in our string such that
 * we can get a sub-string of maximum length which have all same characters.
 * Output:
 * Print an integer which denotes the maximum length possible.
 * @author: 文琛
 * @time: 2020/6/21 19:27
 *
 * 在接手第一时间想到的是尝试采用滑动窗口遍历字符串，并使用hashmap存储 char ： count of char
 * 符合要求的子串，必然存在一个char的数目 >= n - k; 也就是说当前窗口内最多k个杂char
 * 但是这样遍历的过程每个窗口位置都要遍历map获取某char的最大出现次数，时间复杂度较高
 * 于是借鉴了题解：拿题目中限定的大小字母挨个去用窗口去试，时间复杂度为 52n；
 */
public class B06_gfg_k次操作下的最大的单一字符子串长度 {
    public static void main(String[] args) {
        //尝试使用滑动窗口，需要处理数据的输入问题
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T > 0){
            int N = sc.nextInt();
            int K = sc.nextInt();
            String s = sc.next();
            char[] cs = s.toCharArray();
            int res = 1;
            for(int i = 0; i < 26; i++){
                res = Math.max(res, Math.max(method(cs, (char) ('a' + i), K), method(cs, (char) ('A' + i), K)));
            }
            System.out.println(res);
            T--;
        }
    }

    private static int method(char[] cs, char c, int k) {
        int maxLen = 0;
        int count = 0;
        int l = 0, r = 0;
        while(r < cs.length){
            if(cs[r++] != c){
                count++;
            }
            while(count > k){
                if(cs[l++] != c){
                    count--;
                }
            }
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}
