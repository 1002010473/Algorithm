package Fifty;

import java.util.concurrent.TimeoutException;

/**
 * @description:寻找字符串中不含重复字符的子字符串
 * 动态规划：按照常规的动态规划--
 * int[] arr = new int[s.length()];
 *         arr[0]=1;
 *         for (int j = 1;j<arr.length;j++){
 *             if (s.charAt(j)){
 *             }
 *         }
 *         此处，很难求算 第i个字符和它上次出现在字符串中的位置的差距
 *
 *         因此更换辅助数组的构建方式：（结合题目特点）
 *              创建一个对应于26个字母的数组，数组中每个元素记录的是其上次出现的位置index，未出现过则记为-1；
 * @author: 文琛
 * @time: 2020/2/12 16:01
 */
public class FortyEight {
    public static void main(String[] args) throws TimeoutException {
        String s = "a";
        int min = findMin(s);
        System.out.println(min);
    }

    private static int findMin(String s) {
        if (s==null||s.isEmpty()) throw new IllegalArgumentException("invalid parameters");
        int[] position = new int[26];
        for (int i=0;i<26;i++){
            position[i]=-1;
        }
        int curLength=0;
        int maxLength=0;
        for (int j=0;j<s.length();j++){
            int preIndex = position[s.charAt(j)-'a'];
            if (preIndex<0||j-preIndex>curLength){
                curLength++;
            }else  {
                curLength=j-preIndex;
            }
            position[s.charAt(j)-'a']=j;
            maxLength= Math.max(curLength,maxLength);
        }

        return maxLength;
    }
}
