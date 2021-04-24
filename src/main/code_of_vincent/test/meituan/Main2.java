package test.meituan;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 10:14
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.next();
        char[] cs = s.toCharArray();
        int l = 0, r = 0;
        for(char c : cs){
            if(c <= 'Z' && c >= 'A'){
                l++;
            }else{
                r++;
            }
        }
        System.out.println(Math.abs(l - r));
    }
}
