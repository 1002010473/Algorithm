package Algorithm.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个非空字符串s和一个包含非空单词列表的字典wordDict，
 * 判定s是否可以被空格拆分为一个或多个在字典中出现的单词（字典中的单词可重复使用）。
 * @author: 文琛
 * @time: 2020/6/11 14:23
 * 素质三连
 */
public class lc139_单词拆分 {
    public static void main(String[] args) {
        String s = "liwenchen";
        String[] dict = {"li", "haha", "we", "chen", "handsome"};
        List<String> list = new ArrayList<>();
        list.add("li");
        list.add("wench");
        list.add("en");
        System.out.println(method1(s, dict));
        System.out.println(method2(s, list));
        System.out.println(method3(s, list));
    }

    //暴力递归：从头到尾，将s和每个单词比较，如果是其头部子串，继续递归即可
    private static boolean method1(String s, String[] dict) {
        return fun1(s, 0, dict);
    }

    private static boolean fun1(String s, int index, String[] dict) {
        if(index == s.length())
            return true;
        boolean res = false;
        for(String word : dict){
            int len = word.length();
            if((len + index) > s.length()){
                continue;
            }
            boolean flag = true;
            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) != s.charAt(index + i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res = res || fun1(s, index + word.length(), dict);
            }
        }
        return res;
    }
    //备忘：一维index相关数组即可
    //备忘当中，需要拿数组中的相关情况判断，所以需要数组中存在三个状态：初始化，true，false；
    //这样的情况下，dp更合适一些
    private static int[] tab;
    private static boolean method2(String s, List<String> dict) {
        tab = new int[s.length()];
        return fun2(s, 0, dict);
    }

    private static boolean fun2(String s, int index, List<String> dict) {
        if(index == s.length())
            return true;
        if(tab[index] == 2){
            return true;
        }else if(tab[index] == 1){
            return false;
        }
        boolean res = false;
        for(String word : dict){
            int len = word.length();
            if((len + index) > s.length()){
                continue;
            }
            boolean flag = true;
            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) != s.charAt(index + i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res = res || fun2(s, index + word.length(), dict);
            }
        }
        tab[index] = res ? 2 : 1;
        return res;
    }
    //dp:从下往上写入，只需要boolean数组即可
    private static boolean method3(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        //从后往前写
        dp[s.length()] = true;
        for(int i = s.length()-1; i >= 0; i--){
            for(String word : dict){
                int len = word.length();
                if((len + i) > s.length()){
                    continue;
                }
                boolean flag = true;
                for(int j = 0; j < word.length(); j++){
                    if(word.charAt(j) != s.charAt(i + j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    dp[i] = dp[i] || dp[i + len];
                }
            }
        }
        return dp[0];
    }

}
