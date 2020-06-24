package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/6/17 14:04
 */
public class lc17_9键的字母组合 {
    public static void main(String[] args) {
        String s = "23";
        List<String> strings = letterCombinations(s);
        for(String str : strings){
            System.out.println(str);
        }
    }
    private static String[] KEYS =  {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return combinations;
        StringBuilder sb = new StringBuilder();
        return method(digits, combinations, sb);
    }
    //将prefix 和 combinations 传入进去，任何递归过程中的修改都是操作的一个对象
    //避免了将combinations作为成员变量的突兀
    //必须将prefix的改动复原
    public static List<String> method(String digits, List<String> combinations, StringBuilder prefix){
        int len = prefix.length();
        if(len == digits.length()){
            combinations.add(prefix.toString());
            return combinations;
        }
        int num = digits.charAt(len) - '0';
        String s = KEYS[num];
        for(char c : s.toCharArray()){
            prefix.append(c);
            method(digits, combinations, prefix);
            prefix.deleteCharAt(len);
        }
        return combinations;
    }
}
