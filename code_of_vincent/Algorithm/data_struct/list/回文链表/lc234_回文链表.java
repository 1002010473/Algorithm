package Algorithm.data_struct.list.回文链表;



/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/25 11:21
 */
public class lc234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)  return true;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        //快慢指针找到中点 -- 循环结束后的slow --无论奇偶slow.next都会出现在需要翻转的链表首个节点上
        ListNode slow = pre, fast = pre;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = null;
        ListNode cur = slow.next;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        while(last != null){
            if(last.val != head.val) return false;
            last = last.next;
            head = head.next;
        }
        return true;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
