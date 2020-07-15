package Algorithm.twopointers.fastslow;

/**
 * @description: 返回环形链表的入口节点
 * @author: 文琛
 * @time: 2020/6/28 15:02
 */
public class lc142_环形链表2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, quick = head;
        while(quick != null){
            slow = slow.next;
            quick = (quick.next == null ? null : quick.next.next);
            if(slow != null && slow == quick){
                quick = head;
                while(quick != slow){
                    slow = slow.next;
                    quick = quick.next;
                }
                return slow;
            }
        }
        return null;
    }
}
