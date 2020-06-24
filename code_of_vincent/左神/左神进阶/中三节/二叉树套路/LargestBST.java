package 左神.左神进阶.中三节.二叉树套路;

import DataStructure.BinaryTreeNode;

/**
 * @description：获取以root节点为根节点的（没说是二叉搜索树）树中的最大（节点数）搜索二叉树
 * 要么以当前节点为根，要么在当前节点的左子树中，要么在当前节点的右子树中
 * 套路： 需要子树返回给当前节点的信息
 * 1、左子树最大bst的大小 | 右子树最大bst大小
 * 2、左子树最大bst的root | 右子树最大bst大小
 * 3、左子树的max | 右子树的min
 *
 * 所以需要定义一个数据结构来封装当前信息：通用于左子树和右子树
 *
 * 最大bst大小、root、max、min
 *
 * @author: 文琛
 * @time: 2020/5/26 22:13
 */
public class LargestBST {
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
        ReturnType res = process(a);
        System.out.println(res.root.value);
    }

    private static ReturnType process(BinaryTreeNode node) {
        if(node == null)
            return new ReturnType(0,null,Integer.MIN_VALUE,Integer.MAX_VALUE);
        ReturnType left = process(node.leftNode);
        ReturnType right = process(node.rightNode);
        int mergeSize = 0;
        //左子树和右子树可以连接到一起
        if(left.root == node.leftNode && right.root == node.rightNode
            && left.max < node.value && right.min > node.value){
            mergeSize = left.size + right.size + 1;
        }
        int p1 = left.size;
        int p2 = right.size;
        int maxSize = Math.max(Math.max(p1,p2),mergeSize);
        //判断头节点
        BinaryTreeNode maxHead = p1 > p2 ? left.root : right.root;
        if(maxSize == mergeSize)
            maxHead = node;
        return new ReturnType(maxSize, maxHead, Math.min(Math.min(left.min, right.min), node.value),Math.max(Math.max(left.max, right.max),node.value));
    }
}
class ReturnType{
    int size;
    BinaryTreeNode root;
    int max;
    int min;
    public ReturnType(int size, BinaryTreeNode node, int max, int min){
        this.size = size;
        this.root = node;
        this.max = max;
        this.min = min;
    }
}
