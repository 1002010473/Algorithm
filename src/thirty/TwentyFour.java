package thirty;

import util.ListNode;

/**
 * @description:反转链表（围绕反转节点的前后节点展开，不需要其它内存空间）
 * @author: 文琛
 * @time: 2019/12/6 13:47
 */
public class TwentyFour {
    public static void main(String[] args) {
        ListNode node1 = new ListNode();
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

        /*node1.printOut();*/

        /*ListNode newHead = reverseList(node1);
        newHead.printOut();
        System.out.println(newHead.value);*/
        ListNode newHead = reverseList_digui(node1);
        newHead.printOut();
    }

    private static ListNode reverseList_digui(ListNode head) {
        if (head == null) return null;
        if (head.next ==null) return head;
        ListNode newHead = diGui(head);
        head.next = null;
        return newHead;
    }

    private static ListNode diGui(ListNode node) {
        if (node.next!=null) {
            ListNode a = diGui(node.next);
            node.next.next = node;
            return a;
        }else {
            return node;
        }

    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next ==null) return head;
        ListNode now = head;
        ListNode pre = null;
        ListNode temp;
        /*ListNode next1;*/
        while (now!=null){
            temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;

        }
        return pre;

    }
}
