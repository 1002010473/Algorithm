package Algorithm.dac;


import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/14 11:50
 */
public class lc148_链表排序 {
    /*public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        head.next = a;
        a.next = b;
        b.next = c;
        ListNode listNode = sortList(head);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }*/
    public ListNode sortList(ListNode head) {
        //在nlogn的情况下，归并排序实现上更清晰些
        if(head == null || head.next == null)
            return head;
        int len = 0;
        ListNode ahead = new ListNode(0);
        ahead.next = head;
        while(head != null){ // 获取长度
            len ++;
            head = head.next;
        }
        //递归无法保证空间复杂度，尝试迭代
        int l = 1;
        while(l < len){
            for(int j = 1; j + l <= len + 1; j += 2*l){
                merge(ahead, j, j+l-1, j+2*l-1, len);
            }
            l += l;
        }
        return ahead.next;
    }
    public void merge(ListNode ahead, int lo, int mid, int hi, int len){ //笨方法：找到对应的node，一个一个比较添加
        int i = 0;
        ListNode pre = ahead; // pre在lo == 1时，只能为ahead，在其它情况时，可以通过下面的循环实现替换
        ListNode aft = null;
        ListNode front = null;
        ListNode back = null;
        while(i <= len){
            ahead = ahead.next;
            i++;
            if(i ==(lo-1))
                pre = ahead;
            if(i == lo)
                front = ahead;
            if(i ==( mid + 1))
                back = ahead;
            if(i == (hi + 1))
                aft = ahead;
        }
        ListNode back1 = back;
        while(front != back && back1 != aft){
            if(front.val <= back1.val){
                pre.next = front;
                front = front.next;
            }else{
                pre.next = back1;
                back1 = back1.next;
            }
            pre = pre.next;
        }
        while(front != back){
            pre.next = front;
            pre = pre.next;
            front = front.next;
        }
        while(back1 != aft){
            pre.next = back1;
            pre = pre.next;
            back1 = back1.next;
        }
        pre.next = aft;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
