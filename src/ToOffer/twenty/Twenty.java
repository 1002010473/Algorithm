package ToOffer.twenty;

/**
 * @description:
 * @author: 文琛
 * @time: 2019/12/3 12:47
 */
public class Twenty {
    static int index;

    public static void main(String[] args) {
        String s = ".342e+4454";
        char[] chars = s.toCharArray();
        boolean flag = isNumber(chars);
        System.out.println(flag);
        System.out.println(index);
    }

    private static boolean isNumber(char[] chars) {
        index = 0;
        if (chars == null || chars.length ==0) return false;
        boolean flag = scanInteger(chars);
        //判断小数部分
        if (index<chars.length && chars[index] == '.'){
            index++;
            flag = scanUnsignedInteger(chars) || flag;
        }
        //判断指数部分
        if (index<chars.length && chars[index] == 'e' || chars[index] == 'E'){
            index++;
            flag = scanInteger(chars) && flag;
        }
        return index>=chars.length && flag;
    }

    private static boolean scanUnsignedInteger(char[] chars) {
        int temp = index;
        while (index<chars.length && chars[index]>='0'&&chars[index]<='9'){
            index++;
        }
        return index>temp;
    }

    private static boolean scanInteger(char[] chars) {
        if (index<chars.length && chars[index]=='+'||chars[index]=='-'){
            index++;
        }
        return scanUnsignedInteger(chars);
    }
}
