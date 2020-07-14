package Algorithm.ReverseList;

import DataStructure.ListNode;

/**
 * @description: 反转前n个节点
 * 延续上题递归实现
 * @author: 文琛
 * @time: 2020/6/30 15:11
 */
public class 反转链表2 {
    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        ListNode newHead = reverseList(head, 2);
        newHead.printOut();
    }
    //需要将head的next置为newhead的next--需要成员变量
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
