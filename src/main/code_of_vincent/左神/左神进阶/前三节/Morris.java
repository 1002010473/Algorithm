package 左神.左神进阶.前三节;

import DataStructure.BinaryTreeNode;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/5/24 20:52
 */
public class Morris {
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
        morrisMid(a);
        System.out.println();
        morrisBef(a);
        //后序遍历需要额外的操作来实现额外空间复杂度O(1),较为繁琐，待实现

    }

    private static void morrisMid(BinaryTreeNode root) {
        if(root == null)
            return;
        BinaryTreeNode cur = root;
        BinaryTreeNode mostR = null;
        //在即将转移到二叉树的右子节点的时候打印
        //why？ cur = cur.right 发生在两种情况： 1、左子树为空  2、cur是第二次遍历经过时，此时代表左子树遍历完毕
        while(cur != null){
            if(cur.leftNode == null){
                //左子树为空
                System.out.print(cur.value + " ");
                cur = cur.rightNode;
            }else{
                //左子树不为空，寻找左子树的最右节点
                mostR = cur.leftNode;
                while(mostR.rightNode != null && mostR.rightNode != cur){
                    mostR = mostR.rightNode;
                }
                if(mostR.rightNode == null){
                    mostR.rightNode = cur;
                    cur = cur.leftNode;
                }else{ //mostR.right == cur 代表第二次遍历到cur
                    mostR.rightNode = null;
                    System.out.print(cur.value + " ");
                    cur = cur.rightNode;
                }
            }
        }
    }

    private static void morrisBef(BinaryTreeNode root) {
        if(root == null)
            return;
        BinaryTreeNode cur = root;
        BinaryTreeNode mostR = null;
        //先序遍历
        while(cur != null){
            //不能一进入节点就打印：可能是第二次进入到该节点
            if(cur.leftNode == null){
                //左子树为空
                //必然是第一次进入
                System.out.print(cur.value + " ");
                cur = cur.rightNode;
            }else{
                //左子树不为空，寻找左子树的最右节点
                mostR = cur.leftNode;
                while(mostR.rightNode != null && mostR.rightNode != cur){
                    mostR = mostR.rightNode;
                }
                if(mostR.rightNode == null){ // 代表第一次遍历到
                    mostR.rightNode = cur;
                    System.out.print(cur.value+" ");
                    cur = cur.leftNode;
                }else{
                    mostR.rightNode = null;
                    cur = cur.rightNode;
                }
            }
        }
    }
}
