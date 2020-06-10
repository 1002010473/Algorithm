package Algorithm.Window;

import java.util.HashSet;
import java.util.concurrent.TimeoutException;

/**
 * @description:寻找字符串中最长不含重复字符的子字符串
 * 借助窗口特点实现
 * @author: 文琛
 * @time: 2020/2/12 16:01
 */
public class 面试题_48_最长无重复字符子串 {
    public static void main(String[] args){
        String s = "aa";
        int min = lengthOfLongestSubstring(s);
        System.out.println(min);
    }
    //窗口加hash即可搞定
    //r会经过每个元素，相当于遍历并查找以r结尾的每个无重复子串
    //可以通过假设法来验证，当r来到最长子串的右边界，此时l必定在左边界，此时的size就是max（l相当于只有发生重复才移动）
    private static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        while(r < chars.length){
            if(!set.contains(chars[r])){
                set.add(chars[r++]);
                len = Math.max(len, set.size());
            }else{ // set中包含该char，借助循环过程去除set中相关元素（从左到右，每次删一个，直到删除重复元素）
                set.remove(chars[l++]);
            }
        }
        return len;
    }
/*
    private static int findMin(String s) {
        if (s==null||s.isEmpty())
            throw new IllegalArgumentException("invalid parameters");
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
    }*/
}
