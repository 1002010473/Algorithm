package thirty;

import util.Stack_min;

/**
 * @description:实现一种栈，具有O（1）的min函数
 * @author: 文琛
 * @time: 2019/12/11 10:51
 */
public class Thirty {
    public static void main(String[] args) {
        Stack_min stack_min = new Stack_min();
        stack_min.push(2);
        stack_min.push(2);
        System.out.println(stack_min.min());
        stack_min.push(3);
        System.out.println(stack_min.min());
        stack_min.push(1);
        System.out.println(stack_min.min());
        stack_min.pop();
        System.out.println(stack_min.min());
        stack_min.push(1);
    }


}
