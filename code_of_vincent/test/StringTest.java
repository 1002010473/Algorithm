package test;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/25 9:43
 */
public class StringTest {
    public static void main(String[] args) {
        String s = String.valueOf(2143124124);
        System.out.println(s);
        char[] chars = s.toCharArray();
        for(char c : chars){
            System.out.print(c + " ");
        }
        int i = Integer.parseInt(s);
        System.out.println(i +" " + i / 2);
    }
}
