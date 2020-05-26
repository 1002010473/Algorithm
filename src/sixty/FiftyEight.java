package sixty;

import java.util.Stack;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/15 12:25
 */
public class FiftyEight {
    public static void main(String[] args) {
        String s =
                "the sky is blue";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int begin = 0;
        int end= 0;
        int length = chars.length;
        while(begin<length){
            if(chars[begin]!=' '){
                for(int j=begin;j<length;j++){
                    if(chars[j]==' '||j==length-1){
                        end=j;
                        break;
                    }
                }
                String temp = s.substring(begin,end);
                stack.push(temp);
                begin=end+1;
            }else{
                begin++;
            }

        }
        String result = "";
        result+=stack.pop();
        while(!stack.empty()){
            result+=" ";
            String store = stack.pop();
            result+=store;
        }
        return result;
    }
}
