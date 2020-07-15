package Algorithm.kmp;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/15 16:47
 */
public class lc28_实现indexOf {
    //KMP
    public int strStr(String haystack, String needle) {
        //尝试实现KMP
        if(haystack == null || needle == null || needle.length() > haystack.length())
            return -1;
        if(needle.length() == 0) return 0;
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        int[] next = getNext(str2);
        int i1 = 0, i2 = 0;
        while(i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){
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
        return i2 == str2.length ? i1-i2 : -1;
    }
    public int[] getNext(char[] needle){
        int len = needle.length;
        if(len == 1)
            return new int[]{-1};
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int compare = 0;
        while(index < len){
            if(needle[index - 1] == needle[compare]){
                next[index++] = ++compare;
            }else{
                if(compare == 0){
                    next[index++] = 0;
                }else{
                    compare = next[compare];
                }
            }
        }
        return next;
    }

    //暴力比对
    public int strStr1(String haystack, String needle) {
        if(haystack==null) return -1;
        if(needle == null || needle.length()==0) return 0;
        if(needle.length()>haystack.length()) return -1;
        int hl = haystack.length();
        int nl = needle.length();
        for(int i = 0; i <= hl-nl; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j = 1;
                while(j < nl && haystack.charAt(i+j) == needle.charAt(j)){
                    j++;
                }
                if(j == nl)
                    return i;
            }
        }
        return -1;
    }
}
