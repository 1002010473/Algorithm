package Algorithm.DFS.Backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * @author: 文琛
 * @time: 2020/6/17 15:02
 */
public class lc93_IP地址的可能性 {
    public static void main(String[] args) {
        String s = "25525511135";
        String s1 = "1111";
        List<String> strings = restoreIpAddresses(s1);
        for(String str : strings){
            System.out.println(str);
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> strings = new ArrayList<>();
        if(s == null || s.length() == 0)
            return strings;
        StringBuilder sb = new StringBuilder();
        return method(s, sb, 0, 0, 0,strings);
    }

    private static List<String> method(String s, StringBuilder sb,
                                       int index, int sum, int count, List<String> strings) {
        //严格按照IP地址的要求来实现，当加了3个点（count == 3）并且长度也达到了（说明s中每个值都添加完毕）
        if(count == 3 && sb.length() == s.length()+3){
            strings.add(sb.toString());
            return strings;
        }
        if(count > 3 || index == s.length())
            return strings;
        //可能的组合尝试：加. (不能两个.连在一块)（开头不能加.）
        if(sb.length() > 0  && sb.charAt(sb.length()-1) != '.'){
            method(s, sb.append('.'), index, 0, count+1, strings);
            sb.deleteCharAt(sb.length()-1);
        }
        //范围缩小：0后可以加.，但是0后只能加.
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '0' && sum == 0){
            return strings;
        }
        //继续缩小：非0且不超范围的后面可以加数字
        int cur = s.charAt(index) - '0';
        if(sum*10+cur <= 255){
            method(s, sb.append(cur), index+1, sum*10+cur, count,strings);
            sb.deleteCharAt(sb.length()-1);
        }
        return strings;
    }
}
