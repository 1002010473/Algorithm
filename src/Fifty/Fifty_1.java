package Fifty;

/**
 * @description:查找字符串中第一个只出现一次的字符
 * @author: 文琛
 * @time: 2020/2/12 21:32
 */
public class Fifty_1 {
    public static void main(String[] args) {
        String[] strings = {
                "abcdefg",  //a
                "aagbcdef", //g
                "aabccdbd", //不存在
                null
        };
        for (String s:strings){
            char c = firstCharNotReapting(s);
            System.out.println(c);
        }
    }

    private static char firstCharNotReapting(String s) {
        if (s==null||s.length()==0){
            throw new IllegalArgumentException("invalid parameters") ;
        }
        int[] key = new int[256];
        for (int i=0;i<s.length();i++){
            key[s.charAt(i)]++;
        }
        for (int i=0;i<s.length();i++){
            if (key[s.charAt(i)]==1){
                return s.charAt(i);
            }
        }
        return 0;
    }
}
