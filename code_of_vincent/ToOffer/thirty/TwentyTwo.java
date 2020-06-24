package ToOffer.thirty;

import DataStructure.ListNode;

import java.util.Scanner;

/**
 * @description:鲁棒性（健壮性） 查找链表中倒数第k个节点
 * @author: 文琛
 * @time: 2019/12/4 13:30
 */
public class TwentyTwo {
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
        //node1.printOut();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode result = findKToEnd(node1,k);
        if (result!= null){
            System.out.println(result.value);
        }else{
            System.out.println(result);
        }

    }

    private static ListNode findKToEnd(ListNode head, int k) {
        if (k == 0) return null;
        if (head == null) return null;
        ListNode temp = null;
        ListNode start = head;
        ListNode behind = head;
        int count = 1;
        while (start!= null){
            //count ++;
            if (count>=k) {
                temp = behind;
                behind = behind.next;
            }
            count ++;
            start = start.next;
        }
        return temp;
    }
}
