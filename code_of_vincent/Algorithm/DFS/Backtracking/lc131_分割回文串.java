package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/6/19 20:35
 */
public class lc131_分割回文串 {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partition = partition(s);
        for(List<String> list : partition){
            for(String str : list){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        if(s == null || s.length() == 0)
            return lists;
        char[] cs = s.toCharArray();
        List<String> list = new ArrayList<>();
        return method(cs, 0, list, lists);
    }

    private static List<List<String>> method(char[] cs, int i, List<String> list, List<List<String>> lists) {
        if(i == cs.length){
            List<String> l = new ArrayList<>(list);
            lists.add(l);
        }
        for(int j = i ; j < cs.length; j++){
            if(is(cs, i, j)){
                StringBuilder sb = new StringBuilder();
                for(int k = i; k <= j; k++){
                    sb.append(cs[k]);
                }
                list.add(sb.toString());
                method(cs, j+1, list,lists);
                list.remove(list.size()-1);
            }
        }
        return lists;
    }

    private static boolean is(char[] cs, int i, int j) {
        if(i == j)
            return true;
        while(i < j){
            if(cs[i++] != cs[j--]){
                return false;
            }
        }
        return true;
    }
}
