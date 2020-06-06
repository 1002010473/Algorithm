package 左神.左神进阶.中三节.二叉树套路;

import DataStructure.BinaryTreeNode;

/**
 * @description: 获取给定二叉树中任意两节点间的最长距离
 * 节点A到节点B的距离：A到B走的最短路径上的节点个数
 * 套路思维：最长距离要么在当前节点的左子树上，要么在右子树上，要么跨过了当前节点
 * 从而：需要子树提供的信息： 左树的最长距离（case1），右树的最长距离（case2） + 左右子树分别的深度（case3）
 *
 * 在后序遍历的过程中整合信息
 * @author: 文琛
 * @time: 2020/5/27 9:47
 */
public class MaxDistanceInBT {
    public static class ReturnType{
        int length;
        int deep;
        public ReturnType(int length, int deep){
            this.length = length;
            this.deep = deep;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode a = BinaryTreeNode.BSTFactory();
        ReturnType res = process(a);
        System.out.println(res.length);
    }

    private static ReturnType process(BinaryTreeNode node) {
        //basecase
        if(node == null)
            return new ReturnType(0, 0);
        //递归调用
        ReturnType left = process(node.leftNode);
        ReturnType right = process(node.rightNode);
        //分析判断
        int bridgeLength = left.deep + 1 + right.deep;
        int maxLength = Math.max(Math.max(left.length,right.length), bridgeLength);
        int deep = Math.max(left.deep, right.deep) + 1;
        return new ReturnType(maxLength, deep);
    }


}
