package Algorithm.ReverseList;

import DataStructure.ListNode;

/**
 * @description: 单链表的反转--O1时间复杂度：递归和迭代
 * 递归是实现的目标：清晰简单，不需要死扣边边角角
 * @author: 文琛
 * @time: 2020/6/30 14:46
 */
public class lc206_反转链表 {
    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        head.printOut();
        ListNode newHead = reverseList(head);
        newHead.printOut();
        ListNode newHead1 = reverseList1(newHead);
        newHead1.printOut();
    }
    //将前面的节点接在后面节点的尾巴上---递归的出发点
    public static ListNode reverseList(ListNode head) {
        //建立当前节点和next节点的联系
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //迭代：将递归中压栈的信息(pre)保留下来
    public static ListNode reverseList1(ListNode head) {
        if(head == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
