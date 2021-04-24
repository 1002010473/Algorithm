package Algorithm.twopointers.fastslow;
/**
 * @description: 判断链表中是否有环
 * @author: 文琛
 * @time: 2020/6/28 13:58
 */
public class lc141_环形链表 {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode quick = head;
        while(quick != null){
            slow = slow.next;
            quick = (quick.next == null ? null : quick.next.next);
            if(slow == quick && slow != null)
                return true;
        }
        return false;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
