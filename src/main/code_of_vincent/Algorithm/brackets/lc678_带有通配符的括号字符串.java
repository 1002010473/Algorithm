package Algorithm.brackets;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 思路不容易想通哦
 * @author: 文琛
 * @time: 2020/7/29 16:17
 */
public class lc678_带有通配符的括号字符串 {
    public boolean checkValidString(String s) {
        //通过栈来实现
        char[] cs = s.toCharArray();
        Deque<Integer> stack1 = new LinkedList<>();//存储(的index
        Deque<Integer> stack2 = new LinkedList<>();//存储*的index
        for(int i = 0; i < cs.length; i++){
            if(cs[i] == '('){
                stack1.addLast(i);
            }else if(cs[i] == '*'){
                stack2.addLast(i);
            }else{
                if(!stack1.isEmpty()){//能消费（ 就消费，（ 没了就消费*，只要在 )左边即可
                    stack1.removeLast();
                }else{
                    if(stack2.size() > 0){
                        stack2.removeFirst(); // 从利用 * 来消费（ 来看，index 越大的*越有用处，所以先消费index小的
                    }else{
                        return false;
                    }
                }
            }
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack2.peekLast() > stack1.peekLast()){ //只有在（ 右边的*才有资格消费（
                stack1.removeLast();
                stack2.removeLast();
            }else {
                break;
            }
        }
        return stack1.isEmpty();
    }
}
