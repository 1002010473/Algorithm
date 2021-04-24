package Algorithm.kwaymerge;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/14 18:16
 */
public class lc21_两个有序链表合并 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //递归版本
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //迭代方法
        ListNode temp = new ListNode(0);
        ListNode start = temp;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                start.next = l1;
                l1= l1.next;
            }else{
                start.next = l2;
                l2 = l2.next;
            }
            start = start.next;
        }
        if(l1 == null)
            start.next = l2;
        if(l2 == null)
            start.next = l1;
        return temp.next;
    }
}
