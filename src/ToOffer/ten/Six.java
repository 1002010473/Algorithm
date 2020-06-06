package ToOffer.ten;

import DataStructure.ListNode;
import org.junit.Test;

import java.util.Stack;

public class Six {
    /*方法1 ：
    * 利用Stack栈进行颠倒
    * */
    public static void printReverse(ListNode node){
        if (node == null){
            System.out.println("您输入的链表为空");
        }
        Stack<ListNode> nodes = new Stack<>();
        while (node != null){
            nodes.push(node);
            node = node.next;
        }
        while (!nodes.isEmpty()){
            System.out.println(nodes.pop().value);
        }
    }
    public static void printReverse_rec(ListNode node){
        if (node!=null){
            printReverse_rec(node.next);
            System.out.println(node.value);
        }else{
            return;
        }
    }
    @Test
    public void test(){
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.value = 111;
        node2.value = 222;
        node3.value = 333;
        node1.next = node2;
        node2.next = node3;
        printReverse(node1);
        System.out.println("_______");
        printReverse_rec(null);

    }
}
