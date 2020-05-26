package Other.Tree;

import util.BinaryTreeNode;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/4/18 15:37
 */
public class SameTree {
    public static void main(String[] args){
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
        System.out.println(isSameTree(b,null));
    }
    public static boolean isSameTree(BinaryTreeNode left,BinaryTreeNode right){
        //四种情况： 1、都为null  2、3 一个为null，一个不是null 4、都不为null
        //都不为null 又分两种情况：val相等----不相等
        if(left==null && right ==null) return true;
        if(left!=null && right !=null && left.value == right.value){
            return isSameTree(left.leftNode,right.leftNode) && isSameTree(left.rightNode,right.rightNode);
        }
        return false;
    }
}
