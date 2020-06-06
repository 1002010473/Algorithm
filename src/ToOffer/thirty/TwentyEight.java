package ToOffer.thirty;

import DataStructure.BinaryTreeNode;

/**
 * @description:判断某个树是否是对称的二叉树
 * @author: 文琛
 * @time: 2019/12/10 11:29
 */
public class TwentyEight {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(10);
        BinaryTreeNode b = new BinaryTreeNode(6);
        BinaryTreeNode c = new BinaryTreeNode(6);
        BinaryTreeNode d = new BinaryTreeNode(5);
        BinaryTreeNode e = new BinaryTreeNode(7);
        BinaryTreeNode f = new BinaryTreeNode(7);
        BinaryTreeNode g = new BinaryTreeNode(5);
        a.leftNode = b;
        b.leftNode = d;
        a.rightNode = c;
        b.rightNode = e;
        c.leftNode = f;
        c.rightNode = g;
        //a.printTree();
        boolean flag = isSymmetrical(a);
        System.out.println(flag);

    }

    private static boolean isSymmetrical(BinaryTreeNode a) {
        return isSymmetrical(a,a);

    }

    private static boolean isSymmetrical(BinaryTreeNode a, BinaryTreeNode b) {
        if (a==null&&b==null) return true;
        if (a==null||b==null) return false;
        if (a.value!=b.value) return false;
        return isSymmetrical(a.leftNode,b.rightNode)&&isSymmetrical(a.rightNode,b.leftNode);
    }
}
