package 左神.左神进阶.前三节;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/5/20 22:43
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "aabbcdd";
        String str2 = "bb";
        System.out.println(getIndexOf(str1, str2));
    }
    public static int getIndexOf(String str1, String str2){
        if(str1 == null || str2 == null || str2.length() < 1 || str2.length() >str1.length())
            return  -1;
        char[] s = str1.toCharArray();
        char[] m = str2.toCharArray();
        int i1 = 0, i2 = 0;
        int[] next = getNextArray(m);
        while (i1 < str1.length() && i2 < str2.length()){
            if(s[i1] == m[i2]){
                i1++;
                i2++;
            }else{
                if(next[i2] == -1){
                    i1++;
                }else{
                    i2 = next[i2];
                }
            }
        }
        return i2 == str2.length() ? i1-i2 : -1;
    }

    private static int[] getNextArray(char[] str) {
        if(str.length == 1)
            return new int[]{-1};
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while(i < next.length){
            if(str[i-1] == str[cn]){
                next[i++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }
}
