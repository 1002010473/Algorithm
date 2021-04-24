package test.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/17 19:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(i < cs.length){
            if(cs[i] <= '9' && cs[i] >= '0' && i > 0 && cs[i-1] == ' '){
                int start = i;
                while(i < cs.length && cs[i] <= '9' && cs[i] >= '0'){
                    i++;
                }
                String str = s.substring(start, i);
                int j = Integer.parseInt(str);
                if(j < 4000 && j > 999){
                    list.add(j);
                }
            }else{
                i++;
            }
        }
        for(int j : list){
            System.out.print(j + " ");
        }
    }
}
