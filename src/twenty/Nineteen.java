package twenty;

import java.util.Stack;

/**
 * @description:正则表达式的匹配 ‘ .’  ' * '
 * @author: 文琛
 * @time: 2019/12/3 10:54
 */
public class Nineteen {
    /**
     * @param str 字符串
     * @param pattern 模式
     * @return
     */
    public static boolean match(char[] str,char[] pattern){
        //参数校验
        if(str == null || pattern == null || str.length == 0 || pattern.length == 0){
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int pIndex){
        //字符串和模式都已操作完，返回true
        if(strIndex >= str.length && pIndex >= pattern.length)
            return true;
        //字符串没有操作完，模式操作完，返回false
        if(strIndex < str.length && pIndex >= pattern.length)
            return false;
        //字符串操作完，模式没有操作完
        if(strIndex >= str.length && pIndex < pattern.length){
            if(pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*')
                return matchCore(str, strIndex, pattern, pIndex+2);
            else
                return false;
        }

        /**
         * 字符串没有操作完，模式没有操作完
         */
        //如果模式的下一个字符为*
        if(pIndex + 1 < pattern.length && pattern[pIndex+1] == '*'){
            //字符串和模式的当前字符能够匹配
            if(str[strIndex] == pattern[pIndex]){
                return    matchCore(str, strIndex, pattern, pIndex+2)//模式后移2，视为x*匹配0个字符?
                        ||matchCore(str, strIndex+1, pattern, pIndex+2)//视为模式匹配1个字符
                        ||matchCore(str, strIndex+1, pattern, pIndex);//*匹配1个，再匹配str中的下一个
            }else{
                return matchCore(str, strIndex, pattern, pIndex+2);
            }
        }
        else{
            if(str[strIndex] == pattern[pIndex] || pattern[pIndex] == '.'){
                return matchCore(str, strIndex+1, pattern, pIndex+1);
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {

        String str = "abc";
        String pattern = "aab*a";

        boolean result = match(str.toCharArray(), pattern.toCharArray());
        System.out.println(result);
    }
}
