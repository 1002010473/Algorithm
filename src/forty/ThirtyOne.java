package forty;

import java.util.Stack;

/**
 * @description:栈的压入序列对应的弹出序列
 * 借助栈来实现对弹出序列的判断
 *
 * 如果栈顶的数字刚好是要弹出的数字，那么直接弹出即可
 * 如果不是，那么去压栈序列中去查找--即将压栈序列中数字依次插入，判断是否能够找到要弹出的序列；
 * 找到，即将压入序列内该数字前的数字全部压入，并将应弹出的数字弹出
 * 如果全部插入后仍未找到，则该弹出序列不可行。
 *
 * @author: 文琛
 * @time: 2019/12/11 13:29
 */
public class ThirtyOne {
    private static int front=1;
    public static void main(String[] args) {
        int[] in = {1,2,3,4,5};
        int[] out = {4,5,3,1,1};
        int[] outa = {4,3,5,1,2};
        System.out.println(checkOut(in,out));
    }

    private static boolean checkOut(int[] in, int[] out) {
        Stack<Integer> st = new Stack<>();
        st.push(in[0]);
        for (int i = 0;i<out.length;i++){
            if (out[i]==st.peek()){
                st.pop();
            }else{
                push(st,in,out[i]);
                if (st.peek()==out[i]){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    private static void push(Stack<Integer> st, int[] in,  int i) {

        while (front<in.length){
            if (in[front]!=i) {
                st.push(in[front]);
                front++;
            }else{
                st.push(in[front]);
                front++;
                break;
            }
        }
    }
}





/**
 * 栈的压入、弹出序列----更好的解法
 */
/*public class StackSequence {

    public boolean IsPopOrder(int [] pushA,int [] popA){
        Stack<Integer> stack = new Stack<>();

        //参数校验

        if((pushA == null && popA == null) || (pushA.length == 0 && popA.length == 0)){
            return true;
        }
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0){
            return false;
        }
        if(pushA.length != popA.length){
            return false;
        }

        int j =0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        StackSequence test = new StackSequence();
        int [] pushA = {1,2,3,4,5};
        int [] popA = {4,3,5,1,2};

        boolean result = test.IsPopOrder(pushA, popA);
        System.out.println(result);
    }
}*/
