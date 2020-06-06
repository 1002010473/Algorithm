package ToOffer.thirty;


import DataStructure.BinaryTreeNode;

/**
 * @description:比较二叉树的子结构：A树中是否含有B子树的结构
 * @author: 文琛
 * @time: 2019/12/6 20:46
 */
public class TwentySix {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(8);
        BinaryTreeNode b = new BinaryTreeNode(8);
        BinaryTreeNode c = new BinaryTreeNode(7);
        BinaryTreeNode d = new BinaryTreeNode(9);
        BinaryTreeNode e = new BinaryTreeNode(2);
        BinaryTreeNode f = new BinaryTreeNode(4);
        a.leftNode = b;
        b.leftNode = d;
        a.rightNode = c;
        b.rightNode = e;
        e.leftNode = f;
        a.printTree();

        BinaryTreeNode aa = new BinaryTreeNode(8);
        BinaryTreeNode bb = new BinaryTreeNode(9);
        BinaryTreeNode cc = new BinaryTreeNode(1);
        aa.leftNode = bb;
        aa.rightNode = cc;
        aa.printTree();

        boolean flag = isContain(a,aa);
        System.out.println(flag);
    }
    /*比较的思路：
    * 先对比两棵树的根节点，相同则进入一一对照的验证方法；不同则递归调用本方法，遍历查找相同的根节点
    * */
    private static boolean isContain(BinaryTreeNode a, BinaryTreeNode b) {
        boolean result = false;
        if (a!=null && b!=null){
            if (a.value == b.value){
                result = really(a,b);
            }
            if (!result){
                result = isContain(a.leftNode,b);
            }
            if ((!result)) {

                result = isContain(a.rightNode,b);
            }
        }
        return result;
    }

    private static boolean really(BinaryTreeNode a, BinaryTreeNode b) {
        if (b==null) return true;
        if (a==null) return false;
        if (a.value!=b.value)return false;
        return really(a.leftNode,b.leftNode) && really(a.rightNode,b.rightNode);
    }
}
