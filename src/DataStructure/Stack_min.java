package DataStructure;

import java.util.Stack;

/**
 * @description: 一种栈，具有O（1）的min函数--需要辅助栈-----实现三个方法-min-pop-push
 * @author: 文琛
 * @time: 2019/12/11 10:54
 */
public class Stack_min {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = 0;

    //进栈
    public void push(int num){
        dataStack.push(num);
        if (minStack.isEmpty()){
            min = num;
        }else {
            if (num<min){
                min = num;
            }
        }
        minStack.push(min);
    }

    //出栈
    public void pop(){
        if (!dataStack.isEmpty()&&!minStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
        if (!minStack.isEmpty()){
            min = minStack.peek();
        }

    }

    //min函数
    public int min(){
        return min;
    }




}
