package ToOffer.forty;

import DataStructure.RandomListNode;

/**
 * @description:复杂链表的复制--实现不用辅助空间的O（n）算法
 * @author: 文琛
 * @time: 2019/12/14 10:33
 */
public class ThirtyFive {
    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(5);
        RandomListNode clone = Clone(node);
        System.out.println(clone.value);

    }
    public static RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        connectRandom(pHead);
        return reconnectNode(pHead);
    }


    //第一步 在原链表每个结点后面分别复制创建新的结点
    private static void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = new RandomListNode(0);
            pCloned.value = pNode.value;
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }
    //第二步 根据旧链表的兄弟结点 初始化新链表的兄弟结点
    private static void connectRandom(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }

    }
    //第三步 从旧链表拆分得到新的结点
    private static RandomListNode reconnectNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;

        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }

}
