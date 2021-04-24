package Algorithm.转换;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/27 10:46
 */
public class lc8_String转int {
    public int myAtoi(String str) {
        str = str.trim();//删除前后空格
        if (str.length() == 0) return 0;
        char[] cs = str.toCharArray();
        if (!Character.isDigit(cs[0]) && cs[0] != '-' && cs[0] != '+')
            return 0;
        int ans = 0;
        boolean neg = cs[0] == '-';
        int i = !Character.isDigit(cs[0]) ? 1 : 0;
        while (i < cs.length && Character.isDigit(cs[i])) {
            int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (cs[i] - '0')) / 10;
            if (tmp > ans) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 - (cs[i++] - '0');//注意，一直取的是负数，因为int的范围上负数更大
        }
        return neg ? ans : -ans;
    }
}
