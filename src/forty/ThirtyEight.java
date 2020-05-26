package forty;

import java.util.List;

/**
 * @description:字符串内 字符 的全排列
 *
 * 解题思路：
 *
 * 拿到字符串之后，将首字符和后面的字符依次交换，得到首字符的全排列
 *      将得到的首字符的全排列挨个固定首字符，并递归得到第二位字符的全排列。
 *
 * @author: 文琛
 * @time: 2019/12/17 10:16
 */
public class ThirtyEight {
    public static void main(String[] args) {
        String s  = "abc";
        Permution(s);

    }

    private static void Permution(String s) {
        if (s==null||"".equals(s)||s.length()==0) return ;
        StringBuffer stringBuffer = new StringBuffer(s);
        /*int start = 0;*/
        Permution(stringBuffer,0);


    }

    private static void Permution(StringBuffer s, int i) {
        if (i==s.length()-1) {
            String s1 = s.toString();
            System.out.println(s1);
        }else{
            for (int x = i;x<s.length();x++){

                //调换x和i上的字符
                char temp = s.charAt(x);
                s.setCharAt(x,s.charAt(i));
                s.setCharAt(i,temp);

                Permution(s,i+1);

                //复原StringBuffer
                temp = s.charAt(x);
                s.setCharAt(x,s.charAt(i));
                s.setCharAt(i,temp);
            }
        }

    }

}
