package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 请完成一个能够给出 wordword 的所有“缩写”的函数（给出任意一种排列即可）
 * 缩写后两个数字之间不能相邻 -- 大大简化了复杂性
 * DFS：递归尝试每个位置上的可能性，要么替换为数字，要么不变
 * @author: 文琛
 * @time: 2020/7/3 12:41
 */
public class lic779_字符串缩写 {
    public static void main(String[] args) {

    }
    /**
     * @param word: the given word
     * @return: the generalized abbreviations of a word
     */
    public List<String> generateAbbreviations(String word) {
        // Write your code here
        List<String> lists = new ArrayList<>();
        if(word == null || word.length() == 0)
            return lists;
        char[] cs = word.toCharArray();
        boolean[] flags = new boolean[cs.length];
        helper(cs, -1, flags, lists);
        return lists;
    }
    public void helper(char[] cs, int index, boolean[] flags, List<String> lists){
        if(index == cs.length-1){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(int i = 0; i < cs.length; i++){
                if(flags[i]){
                    count++;
                }else{
                    if(count > 0){
                        sb.append(count);
                        count = 0;
                    }
                    sb.append(cs[i]);
                }
                if(i == cs.length-1 && count > 0)
                    sb.append(count);
            }
            lists.add(sb.toString());
            return;
        }
        helper(cs, index+1, flags, lists);
        flags[index+1] = true;
        helper(cs, index+1, flags, lists);
        flags[index+1] = false;

    }
}

