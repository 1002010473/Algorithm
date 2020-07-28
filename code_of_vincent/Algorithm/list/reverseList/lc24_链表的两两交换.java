package Algorithm.list.reverseList;

import DataStructure.ListNode;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/28 10:45
 */
public class lc24_链表的两两交换 {
    public ListNode swapPairs(ListNode head) {
        //尝试复现k个一组翻转链表
        if(head == null) return null;
        ListNode newHead = method(head, 2);
        return newHead;
    }
    public ListNode method(ListNode node, int k) {
        int n = k;
        ListNode head = node;
        while(n > 0){
            if(head == null) return node;
            head = head.next;
            n--;
        }
        ListNode nhead = reverse(node, k);
        node.next = method(head, k);
        return nhead;
    }
    ListNode pre = null;
    public ListNode reverse(ListNode node, int k){
        if(k == 1){
            pre = node.next;
            return node;
        }
        ListNode newHead = reverse(node.next, k -1);
        node.next.next = node;
        node.next = pre;
        return newHead;
    }
}
