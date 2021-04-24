package test.qq;

import java.util.Scanner;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 20:02
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        ListNode pre1 = new ListNode();
        ListNode pre = pre1;
        for(int i = 0; i < n; i++){
            pre.next = new ListNode(sc.nextInt());
            pre = pre.next;
        }
        int m = sc.nextInt();
        ListNode pre2 = new ListNode();
        pre = pre2;
        for(int i = 0; i < m; i++){
            pre.next = new ListNode(sc.nextInt());
            pre = pre.next;
        }
        ListNode a = pre1.next;
        ListNode b = pre2.next;
        while(a != null && b != null){
            if(a.val == b.val){
                System.out.println(a.val);
                a = a.next;
                b = b.next;
            }else if(a.val > b.val){
                a = a.next;
            }else{
                b = b.next;
            }
        }
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
}
