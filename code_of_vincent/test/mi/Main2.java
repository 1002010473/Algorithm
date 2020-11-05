package test.mi;



import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/15 19:43
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for(char c : cs){
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
