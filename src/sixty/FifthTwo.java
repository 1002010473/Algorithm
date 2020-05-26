package sixty;

import util.ListNode;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/13 18:18
 */
public class FifthTwo {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int dif = lengthA-lengthB;
        ListNode longer;
        ListNode shorter;
        int steps = 0 ;
        if(dif>=0){
            longer = headA;
            shorter = headB;
            steps=lengthB;
        }else{
            longer = headB;
            shorter = headA;
            steps=lengthA;
        }
        for(int i = 0;i<Math.abs(dif);i++){
            longer = longer.next;
        }
        for(int j=0;j<steps;j++){
            if(longer==shorter){
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }
    public int getLength(ListNode node){
        if(node == null ){
            return 0;
        }
        int length = 1;
        while(node.next!=null){
            length++;
            node = node.next;
        }
        return length;
    }
}
