package Algorithm.twopointers.fastslow;

/**
 * @description: 给定非空单链表，返回中间节点，如果中间节点存在两个，返回后者
 * @author: 文琛
 * @time: 2020/6/28 14:17
 */
public class lc876_链表中间节点 {
    public ListNode middleNode(ListNode head) {
        //快慢指针
        ListNode slow = head;
        ListNode quick = head;
        while(quick!=null && quick.next!=null){
            slow = slow.next;
            quick = quick.next.next;

        }
        return slow;
    }
}
