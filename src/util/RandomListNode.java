package util;

/**
 * @description: 复杂链表--两个指针，一个是链表中下一个节点，另一个是链表中随机的节点或者是null；
 * @author: 文琛
 * @time: 2019/12/14 10:30
 */


public class RandomListNode {
    public int value;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int value) {
        this.value = value;
    }
}
