package 左神.左神初级;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/19 22:58
 */
public class 两个栈实现队列 {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public 两个栈实现队列() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.addFirst(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.addFirst(stack1.removeFirst());
            }
        }
        if(stack2.isEmpty()) return -1;
        return stack2.removeFirst();
    }
}
