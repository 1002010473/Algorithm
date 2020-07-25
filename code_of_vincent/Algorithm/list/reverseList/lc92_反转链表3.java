package Algorithm.list.reverseList;

import DataStructure.ListNode;

/**
 * @description: 反转从位置 m 到 n 的链表
 * @author: 文琛
 * @time: 2020/6/30 22:16
 */
public class lc92_反转链表3 {
    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        ListNode newHead = reverseBetween(head, 2,3);
        newHead.printOut();
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1)
            return reverseList(head, n);
        //反转部分返回newhead，非反转部分返回head
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }
    static ListNode successor = null;
    public static ListNode reverseList(ListNode head, int count) {
        if(count == 1){
            successor = head.next;
            return head;
        }
        ListNode newHead = reverseList(head.next, count-1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }
}
