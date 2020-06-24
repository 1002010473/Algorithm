package ToOffer.forty;

import DataStructure.BinaryTreeNode;



/**
 * @description:
 * @author: 文琛
 * @time: 2019/12/14 13:41
 */
public class ThirtySix_ {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(10);
        BinaryTreeNode b = new BinaryTreeNode(6);
        BinaryTreeNode c = new BinaryTreeNode(14);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(8);
        BinaryTreeNode f = new BinaryTreeNode(12);
        BinaryTreeNode g = new BinaryTreeNode(16);
        a.leftNode = b;
        b.leftNode = d;
        a.rightNode = c;
        b.rightNode = e;
        c.leftNode = f;
        c.rightNode = g;
        a.printTree();//         中序 递归
        BinaryTreeNode node = Convert(a);
        node.printTree();
    }
    private static BinaryTreeNode pre = null;
    private static BinaryTreeNode head = null;

    public static BinaryTreeNode Convert(BinaryTreeNode root) {
        inOrder(root);
        return head;
    }

    private static void inOrder(BinaryTreeNode node) {
        if (node == null)
            return;
        inOrder(node.leftNode);
        node.leftNode = pre;
        if (pre != null)
            pre.rightNode = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.rightNode);
    }

}
