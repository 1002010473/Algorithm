package ToOffer.ten;

import DataStructure.Queue_2Stack;

public class Nine {
    public static void main(String[] args) {
        Queue_2Stack<Integer> queue = new Queue_2Stack<>();
        queue.appendToTail(1);
        queue.appendToTail(2);
        queue.appendToTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendToTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
