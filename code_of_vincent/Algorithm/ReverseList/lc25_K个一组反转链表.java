package Algorithm.ReverseList;

import DataStructure.ListNode;

/**
 * @description: k个一组，进行反转，不足k个的不进行操作
 * @author: 文琛
 * @time: 2020/6/30 22:46
 */
public class lc25_K个一组反转链表 {
    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        ListNode node = reverseKGroup(head, 2);
        node.printOut();
    }
    //主体递归 + 反转递归
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode tail = head;
        for(int i = k; i > 0; i--){
            if(tail == null)
                return head;
            tail = tail.next;
        }
        ListNode newHead =  reverseList(head, k);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }
    //反转前k个
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
