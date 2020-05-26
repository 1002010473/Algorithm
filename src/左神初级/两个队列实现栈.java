package 左神初级;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/19 22:58
 */
public class 两个队列实现栈 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
}
class MyStack {
    private Deque<Integer> data;
    private Deque<Integer> assist;
    private int size;
    //private int pre;
    /** Initialize your data structure here. */
    public MyStack() {
        data = new LinkedList<Integer>();
        assist = new LinkedList<Integer>();
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        data.addLast(x);
        size++;
        //pre = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(data.size()>1){
            assist.addLast(data.removeFirst());
        }
        int res = data.remove();
        swap();
        size--;
        return res;

    }
    //两个队列的引用交换
    private void swap() {
        Deque<Integer> tmp = data;
        data = assist;
        assist = tmp;
    }

    /** Get the top element. */
    public int top() {
        //return data.get(data.size()-1);
        return data.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }
}


