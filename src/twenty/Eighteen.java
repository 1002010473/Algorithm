package twenty;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;
import util.ListNode;

/**
 * @description:问题1--高效的删除链表节点 -- 无需遍历
 *              问题2--删除有序链表中重复的节点--重复的节点都要删除，无需保留剩一个
 * @author: 文琛
 * @time: 2019/12/2 10:49
 */
public class Eighteen {
    public static void deleteNode(ListNode head,ListNode toBeDelete){
        //参数效验
        if (head==null||toBeDelete==null){
            return;
        }
        //链表中只有一个节点
        if (head==toBeDelete && head.next==null){
            head = null;
        }else if (toBeDelete.next==null){   //要删除的节点在末尾
            ListNode temp = head;
            while (temp.next != toBeDelete){
                temp = temp.next;
            }
            temp.next = null;
        }else{     //正常的删除情况
            toBeDelete.value = toBeDelete.next.value;
            toBeDelete.next = toBeDelete.next.next;
        }

    }
    /*该方法将重复的节点删除，但会保留一个*/
    public static void deleteDuplication(ListNode head){
        //参数校验
        if (head == null){
            return;
        }
        ListNode temp = head;
        int compare = temp.value-1;
        while (temp != null){
            int j = temp.value;
            if (compare == j){
                //deleteNode(head,temp.next);
                if (temp.next == null ){
                    deleteNode(head,temp);
                    temp = null;
                }else{
                    deleteNode(head,temp);
                }
                continue;
            }
            compare = j;
            temp = temp.next;
        }

    }
    public static ListNode deleteDuplicationClearly(ListNode head ){
        if (head == null){
            return null;
        }
        ListNode preNode = new ListNode();
        ListNode temp = preNode;
        preNode.next = head;
        ListNode nowNode = head;

        while (nowNode != null){
            if (nowNode.next!=null && nowNode.value == nowNode.next.value){
                while (nowNode.next!=null && nowNode.value == nowNode.next.value){
                    nowNode = nowNode.next;
                }
                preNode.next = nowNode.next;
            }else{
                preNode = nowNode;

            }
            nowNode = nowNode.next;
        }
        return temp.next;
    }

    @Test
    public void testDeleteNode(){
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        node1.value = 222;
        node2.value = 222;
        node3.value = 222;
        node4.value = 333;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.printOut();
        deleteNode(node1,node1);
        node1.printOut();
    }
    @Test
    public void testDeleteDuplicationNode(){
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        node1.value = 111;
        node2.value = 222;
        node3.value = 222;
        node4.value = 222;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.printOut();
        deleteDuplication(node1);
        node1.printOut();
    }
    @Test
    public void testDeleteDuplicationNode_1(){
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
        node4.value = 3;
        node5.value = 3;
        node6.value = 4;
        node7.value = 4;
        node8.value = 5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node1.printOut();
        ListNode node = deleteDuplicationClearly(node1);
        node.printOut();
    }
}
