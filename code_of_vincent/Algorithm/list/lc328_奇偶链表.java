package Algorithm.list;

import DataStructure.ListNode;

/**
 * @description: 拆分奇偶位置上的链表，并将偶链表续在奇链表的尾巴上
 * @author: 文琛
 * @time: 2020/7/25 10:40
 */
public class lc328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode pre1 = new ListNode();//两个头
        ListNode pre2 = new ListNode();
        ListNode end1 = pre1;
        ListNode end2 = pre2;
        while(head != null){
            end1.next = head;
            end1 = end1.next;
            end2.next = head.next;
            end2 = end2.next;
            head = (head.next == null ? null : head.next.next);
        }
        end1.next = pre2.next;
        return pre1.next;
    }
}
