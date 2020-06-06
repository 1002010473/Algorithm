package DataStructure;

import org.junit.Test;
//链表
public class ListNode {
    public ListNode next;
    public int value;

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }

    public void printOut(){
        System.out.print(value);
        ListNode tmp = next;
        while (tmp!=null){
            System.out.print(","+tmp.value);
            tmp = tmp.next;
        }
        System.out.println();
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
        node1.printOut();
        /*ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        ListNode node7 = new ListNode();
        ListNode node8 = new ListNode();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node4.value = 4;
        node5.value = 5;
        node6.value = 6;
        node7.value = 7;
        node8.value = 8;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        //node1.printOut();*/

    }
}
