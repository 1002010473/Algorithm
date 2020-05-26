package thirty;

import util.ListNode;

/**
 * @description:查找链表中环的入口节点--环（链表中后面的节点指向前面的某个节点）
 * @author: 文琛
 * @time: 2019/12/5 14:48
 */
public class TwentyThree {
    private static ListNode node;
    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        ListNode node7 = new ListNode();
        ListNode node8 = new ListNode();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node4.value = 4;
        node5.value = 5;
        node6.value = 6;
        node7.value = 7;
        node8.value = 8;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node3;
        //node1.printOut();
        boolean flag = hasLoop(node1);
        System.out.println(flag);
        int numofloop ;
        if (flag){
            numofloop = findLengthOfLoop(node);
            System.out.println(numofloop);
            ListNode entrance = findStart(node1,numofloop);
            System.out.println(entrance.value);
        }
    }

    private static ListNode findStart(ListNode head, int numofloop) {

        ListNode start = head;
        ListNode end = head;
        for (int i=0;i<numofloop;i++){
            start = start.next;
        }
        while (start!=end){
            start=start.next;
            end = end.next;
        }
        return start;

    }

    private static int findLengthOfLoop(ListNode node) {
        int length =1 ;
        ListNode temp = node;
        while (temp.next!=node){
            length++;
            temp = temp.next;
        }
        return length;
    }

    private static boolean hasLoop(ListNode head) {
        if (head == null) return false;
        //if (head.next == head) return true;

        ListNode x = head;
        ListNode y = head;
        while (x.next.next!= null){
            x = x.next.next;
            y = y.next;
            if (x==y){
                node = x;
                return true;
            }
        }
        return false;
    }
}
