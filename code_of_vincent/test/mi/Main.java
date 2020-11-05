package test.mi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/15 19:29
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            //int len = s.length();
            Deque<Character> stack = new LinkedList<>();
            char[] cs = s.toCharArray();
            boolean flag = true;
            for(char c : cs){
                if(!flag){
                    break;
                }
                if(c == '(' || c == '{' || c == '['){
                    stack.addLast(c);
                }else{
                    if(c == ')'){
                        if(stack.isEmpty() || stack.removeLast() != '('){
                            flag = false;
                        }
                    }
                    if(c == '}'){
                        if(stack.isEmpty() || stack.removeLast() != '{'){
                            flag = false;
                        }
                    }
                    if(c == ']'){
                        if(stack.isEmpty() || stack.removeLast() != '['){
                            flag = false;
                        }
                    }
                }
            }
            if(flag && stack.isEmpty()){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }
    }
}
