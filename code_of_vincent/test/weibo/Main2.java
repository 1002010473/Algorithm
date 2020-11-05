package test.weibo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/13 16:17
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        boolean flag = true;
        for(int i = 1; i < cs.length; i++){
            if(cs[i] == cs[i - 1]){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
