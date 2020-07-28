package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/27 10:43
 */
public class ah {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        for(String s : strings){
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0) return list;
        StringBuilder sb = new StringBuilder();
        method(sb, 0, 0, n, list);
        return list;
    }
    public static void method(StringBuilder sb, int left, int right, int n, List<String> list){
        if(left == n && right == n){
            list.add(sb.toString());
            return;
        }
        if(left > n || right > n) return;
        sb.append('(');
        method(sb, left+1, right, n, list);
        sb.deleteCharAt(sb.length() - 1);
        if(left < right){
            sb.append(')');
            method(sb, left, right+1, n, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
