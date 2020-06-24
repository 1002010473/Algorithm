package 左神.左神初级;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * 笔试：要求低--On空间复杂度
 * 面试：要求高--O1空间复杂度
 *
 * @author: 文琛
 * @time: 2020/2/21 20:39
 */

class ListNode1 {
     int val;
     ListNode1 next;
     ListNode1(int x) { val = x; }
 }

public class 回文链表的判断 {

    //方法1 最简单的思路：快的每次走两步，慢的 每次走一步，但是存在问题，链表长度不确定奇偶，所以需要一个长度的计数器
    public boolean isPalindrome0(ListNode1 head) {
        //快慢指针+压栈--空间复杂度On
        if(head==null) return true;
        ListNode1 quick = head;
        //其实这里并没有用到slow---该实现较为简陋
        ListNode1 slow = head;
        int len = 0;
        while(quick!=null){
            len++;
            if(quick.next!=null){
                quick = quick.next.next;
                len ++;
            }else{
                quick = quick.next;
            }
        }
        int half = len/2;
        Deque<ListNode1> deque = new LinkedList();
        while(half-- >0){
            deque.addFirst(head);
            head = head.next;
        }
        //根据长度的奇数偶数确定开始比对的起点
        ListNode1 start;
        if(len%2==0){
            start = head;
        }else{
            start = head.next;
        }
        //开始比对
        while(!deque.isEmpty()){
            ListNode1 r = deque.removeFirst();
            if(r.val!=start.val){
                return false;
            }
            start = start.next;
        }
        return true;
    }
    //方法2：方法1的改进版，但仍采用On的空间复杂度==转换为长度

    public boolean isPalindrome1(ListNode1 head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode1 currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        //更加优雅的双指针
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    //方法3 O1空间复杂度==后半段链表的翻转
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public boolean isPalindrome(ListNode1 head) {
        if(head == null) return true;
        if(head.next == null ) return true;
        //O1空间复杂度的实现--需要进行后半段链表的翻转
        ListNode1 head1= head;
        ListNode1 quick = new ListNode1(0);
        ListNode1 slow = new ListNode1(0);
        slow.next = head;
        quick.next  = head;
        while(quick.next!=null){

            if(quick.next.next!=null){
                quick = quick.next.next;
            }else{
                quick = quick.next;
                break;//如果发生触底，那么立即break，slow不再next
            }

            slow = slow.next;
        }

        ListNode1 behindHead = slow.next;//反转链表的head标记
        //将前半部的尾部指向null
        slow.next = null;
        //进行反转
        ListNode1 pre = null;
        while(behindHead!=null){
            ListNode1 nextNode  = behindHead.next;
            behindHead.next = pre;
            pre = behindHead;
            behindHead = nextNode;
        }
        //进行比对
        while(pre!=null && head!=null){
            if(pre.val!=head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        //需要进行链表的复原
        //待写
        return true;
    }



}
