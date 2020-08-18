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
class MyQueue {
    Deque<Integer> data;
    Deque<Integer> assist;
    int size;
    /** Initialize your data structure here. */
    public MyQueue() {
        data = new LinkedList<>();
        assist = new LinkedList<>();
        size = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        data.addLast(x);
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res;
        if(assist.size() == 0){
            while(!data.isEmpty()){
                assist.addLast(data.removeLast());
            }
        }
        res = assist.removeLast();
        size--;
        return res;
    }

    /** Get the front element. */
    public int peek() {
        if(assist.size() == 0){
            while(!data.isEmpty()){
                assist.addLast(data.removeLast());
            }
        }
        return assist.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
