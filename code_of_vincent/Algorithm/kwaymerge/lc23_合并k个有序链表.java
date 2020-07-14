package Algorithm.kwaymerge;

import java.util.PriorityQueue;

/**
 * @description: hard问题，重在时间复杂度的反思提升
 * @author: 文琛
 * @time: 2020/7/5 9:44
 */
public class lc23_合并k个有序链表 {
    //第一思路，按照两个有序链表的合并思路，比较合并 -- 296ms
    public ListNode mergeKLists(ListNode[] lists) {
        //尝试按照之前两个链表合并的逻辑来实现
        if(lists == null || lists.length == 0)
            return null;
        int len = lists.length;
        if(len == 1)
            return lists[0];
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        boolean  flag = false;
        while(!flag){
            int min = Integer.MAX_VALUE;
            int index = -1;
            //遍历比较：O k
            for(int i = 0; i < len; i++){
                if(lists[i] != null && lists[i].val < min){
                    min = lists[i].val;
                    index = i;
                }
            }
            if(index == -1){
                flag = true;
            }else{
                pre.next = lists[index];
                lists[index] = lists[index].next;
                pre = pre.next;
            }
        }
        return res.next;
    }
    //尝试改进：将每个链表头部的遍历比较的过程替换为 小根堆 的插入 -- 5ms
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        int len = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, (a, b) -> a.val - b.val);
        ListNode pre = new ListNode(0);
        ListNode p = pre;
        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null)
                queue.add(p.next);
        }
        return pre.next;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
