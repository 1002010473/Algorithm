package ToOffer.thirty;

import DataStructure.ListNode;

/**
 * @description:合并有序的两个链表
 * @author: 文琛
 * @time: 2019/12/6 16:18
 */
public class TwentyFive {
    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.value = 1;
        node2.value = 4;
        node3.value = 5;
        node1.next = node2;
        node2.next = node3;
        ListNode nodea = new ListNode();
        ListNode nodeb = new ListNode();
        ListNode nodec = new ListNode();
        nodea.value = 3;
        nodeb.value = 4;
        nodec.value = 7;
        nodea.next = nodeb;
        nodeb.next = nodec;
        node1.printOut();
        nodea.printOut();

        ListNode newHead = emerge(node1,nodea);
        newHead.printOut();
    }

    private static ListNode emerge(ListNode node1, ListNode nodea) {
        if (node1==null&&nodea==null) {
            return null;
        }else if (node1==null&&nodea!=null){
            return nodea;
        }else if (node1!=null&&nodea==null){
            return node1;
        }
        ListNode newHead = new ListNode();
        //node1.value>nodea.value?nodea:node1;
        addList(newHead,node1,nodea);


        /*ListNode temp = newHead;

        while(node1.next!=null||nodea.next!=null){
            temp.next =
        }*/

        return newHead.next;
    }

    private static void addList(ListNode newHead, ListNode node1, ListNode nodea) {
        if (node1!=null && nodea!=null) {
            if (node1.value>=nodea.value){
                newHead.next = nodea;
                addList(newHead.next,node1,nodea.next);
            }else{
                newHead.next = node1;
                addList(newHead.next,node1.next,nodea);
            }
        }
        if (node1==null && nodea!=null){
            newHead.next = nodea;
        }
        if (node1!=null && nodea==null){
            newHead.next = node1;
        }
        if (node1==null && nodea==null){
            newHead.next = null;
        }
        //newHead.next = node1.value>nodea.value?nodea:node1;
    }
}
