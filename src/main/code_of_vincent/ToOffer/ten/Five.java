package ToOffer.ten;
/**
 * @description: 遥想去年此时，启东工位上刷题，在不熟悉Java数据结构的情况下，处理该题时很是头痛，哈
 * @param null
 * @return:
 * @author: Vincent
 * @time: 2020/11/13 20:53
 */

public class Five {
    public static void main(String[] args) {
        String s = "awueuf asdf    asdfasdf";
        String s1 = replace(s);
        System.out.println(s1);
    }
    /*在数据结构使用熟悉的情况下，没必要按照其指定的方式去处理，简单理解题目的意思即可
    * */
    private static String replace(String s){
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for(char c : cs){
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
