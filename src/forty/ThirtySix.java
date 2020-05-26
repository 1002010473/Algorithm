package forty;

import util.BinaryTreeNode;

/**
 * @description: 二叉搜索树转变为双向链表（有序） 二叉树的每个节点都有两个指向其它节点的指针，双向链表的每个
 * 节点也是含有两个指针，分别指向前后两个节点。
 * @author: 文琛
 * @time: 2019/12/14 13:05
 */
public class ThirtySix {
    private static BinaryTreeNode lastNodeInList;
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
        BinaryTreeNode node = convert(a);
        System.out.println(node.value);
        //System.out.println(node.leftNode.value);
        System.out.println(node.rightNode.leftNode.value);


    }
    public static BinaryTreeNode convert(BinaryTreeNode root) {
        //指向双向链表的尾节点
        lastNodeInList = null;
        convertNode(root);

        //我们需要返回头结点
        BinaryTreeNode head = lastNodeInList;
        while(head != null && head.leftNode != null){
            head = head.leftNode;
        }
        return head;
    }

    //使用递归进行转换
    public  static void convertNode(BinaryTreeNode node) {
        if(node == null)
            return ;

        BinaryTreeNode currentNode = node;
        if(currentNode.leftNode != null){
            convertNode(currentNode.leftNode);
        }
        currentNode.leftNode = lastNodeInList;
        if(lastNodeInList != null){
            lastNodeInList.rightNode = currentNode;
        }
        lastNodeInList = currentNode;
        if(currentNode.rightNode != null){
            convertNode(currentNode.rightNode);
        }
    }


}
