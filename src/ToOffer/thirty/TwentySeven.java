package ToOffer.thirty;

import DataStructure.BinaryTreeNode;

/**
 * @description: 求 二叉树 的 镜像
 * 解题思路： 前序遍历， 遍历到的节点如果有子节点 那么交换子节点
 * @author: 文琛
 * @time: 2019/12/9 17:21
 */
public class TwentySeven {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(10);
        BinaryTreeNode b = new BinaryTreeNode(6);
        BinaryTreeNode c = new BinaryTreeNode(14);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(8);
        BinaryTreeNode f = new BinaryTreeNode(12);
        a.leftNode = b;
        b.leftNode = d;
        a.rightNode = c;
        b.rightNode = e;
        c.leftNode = f;
        a.printTree();
        System.out.println();
        Mirror(a);
        a.printTree();
    }

    private static void Mirror(BinaryTreeNode root) {
        if (root == null){
            return;
        }
        if (root.leftNode!=null||root.rightNode!=null){
            BinaryTreeNode temp = root.leftNode;
            root.leftNode = root.rightNode;
            root.rightNode = temp;
        }
        if (root.leftNode!=null){
            Mirror(root.leftNode);
        }
        if (root.rightNode!=null){
            Mirror(root.rightNode);
        }
    }
}
