package util;

import java.util.Stack;
/*
* 长度可变*/
public class Queue_2Stack<T> {
    /*java自带Stack类
    查看栈顶：peek()
    压入栈顶：push()
    弹出栈顶并返回：pop()
     */
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void appendToTail(T t){
        stack1.push(t);
    }

    public T deleteHead(){
        T out = null ;
        if (stack2.isEmpty()){
            if (stack1.isEmpty()){
                return null;
            }else{
                while (!stack1.isEmpty()){
                    T pop = stack1.pop();
                    stack2.push(pop);
                }
                out = stack2.pop();
            }

        }else{
            out = stack2.pop();
        }
        return out;
    }
}
