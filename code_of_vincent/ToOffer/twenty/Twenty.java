package ToOffer.twenty;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: .123可以表示0.123，1.可以表示1.0，但是指数部分必须为整数，可能存在空格
 * 分而治之，将多个方面的判断功能切分为e, ., 符号的分别判断
 * @author: 文琛
 * @time: 2019/12/3 12:47
 */
public class Twenty {
    public static void main(String[] args) {
        String s = ".342e+4454";
        boolean flag = isNumber(s);
        System.out.println(flag);
    }

    public static  boolean isNumber(String s) {
        s = s.trim();//去除前后空格
        if(s.length() == 0)
            return false;
        s = s.toUpperCase();//e 和 E 整合，方便一起处理
        if(s.charAt(0) == 'E' || s.charAt(s.length() - 1) == 'E')
            return false;//排除以e开头或者结尾的情况，因为split之后无法判断
        String[] ss = s.split("E");
        int si = ss.length;
        if(si == 2){
            return judgeWithFlag(ss[0], true) && judgeWithFlag(ss[1], false);
        }else if (si == 1){
            return judgeWithFlag(ss[0], true);
        }else{//length > 2，说明存在多个String，肯定false，0个肯定也是false；
            return false;
        }
    }
    //判断处理，将符号的判断逻辑剥离出来，传入的flag是为了传入method，在该层并没有发挥作用
    private static boolean judgeWithFlag(String s, boolean flag) {
        char c = s.charAt(0);
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        if(c == '+' || c == '-'){
            if(len == 1) return false;
            return method(sb.substring(1,sb.length()), flag);
        }else{
            return method(s, flag);
        }
    }
    //判断该数字是否是一个不带符号和e的数
    private static boolean method(String s, boolean flag) {
        char[] cs = s.toCharArray();
        if(cs.length == 1 && cs[0] == '.')
            return false;
        boolean f = false;
        for(char c : cs){
            if(c == '.'){
                if(!flag || f) return false;//flag==false，代表不能是分数，不能有小数点
                f = true;
            }else if(c <= '9' && c >= '0'){

            }else{
                return false;
            }
        }
        return true;
    }
}
