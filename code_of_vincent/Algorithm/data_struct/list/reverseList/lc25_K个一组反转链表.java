package Algorithm.data_struct.list.reverseList;

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
    //k内循环判断 + 递归K + 递归翻转
    public static ListNode reverseKGroup(ListNode head, int k) { //返回自head开始的k个节点翻转后的newhead
        if(head == null) return null;
        ListNode cur = head;
        for(int i = k; i > 0; i--){ //先定位好下个递归的起始节点
            if(cur == null)
                return head;//如果不够的话，直接将head返回即可
            cur = cur.next;
        }
        ListNode newHead =  reverseList(head, k);
        head.next = reverseKGroup(cur, k);
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
