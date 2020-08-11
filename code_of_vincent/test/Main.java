package test;

import java.util.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/2 9:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < count; i++){
            int n = sc.nextInt();
            while(!stack.isEmpty() && stack.peekLast() > n){
                int r = stack.removeLast();
                list.add(r);
            }
            stack.addLast(n);
        }
        //按照单调增的栈来进行判断
        int res = 0;
        for(int i = 0; i < list.size(); i++){
            int com = list.get(i);
            res++;//基本的拿出来再放回去
            if(!stack.isEmpty() && com > stack.peekFirst() && com < stack.peekLast()){
                int left = 0, right = 0;
                Deque<Integer> stack1 = new LinkedList<>(stack);
                while(!stack1.isEmpty() && stack1.peekFirst() < com){
                    stack1.removeFirst();
                    left++;
                }
                while (!stack1.isEmpty() && stack1.peekLast() > com) {
                    stack1.removeLast();
                    right++;
                }
                if(left <= right){
                    while(left-- > 0){
                        stack.removeFirst();
                    }
                    res += left;
                }else{
                    while(right-- > 0){
                        stack.removeLast();
                    }
                    res += right;
                }
            }
        }
        System.out.println(res);
    }

}
