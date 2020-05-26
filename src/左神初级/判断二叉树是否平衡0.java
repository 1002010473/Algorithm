package 左神初级;


import util.BinaryTreeNode;

/**
 * @description:
 * 递归的调用
 * 1 列出可能性
 * 2 设计递归函数：返回的信息
 * 3 函数内部实现
 * @author: 文琛
 * @time: 2020/2/22 22:26
 */
public class 判断二叉树是否平衡0 {
    class ReturnData{
        int val;
        boolean isB;
        ReturnData(int val,boolean isB){
            this.val = val;
            this.isB = isB;
        }
    }
    public boolean isBalanced(BinaryTreeNode root) {
        return method(root).isB;

    }
    public ReturnData method(BinaryTreeNode node){
        if(node==null) return new ReturnData(0,true);
        ReturnData leftDa = method(node.leftNode);
        if(!leftDa.isB){
            return new ReturnData(0,false);
        }
        ReturnData rightDa = method(node.rightNode);
        if(!rightDa.isB){
            return new ReturnData(0,false);
        }
        if(Math.abs(leftDa.val-rightDa.val)>1){
            return new ReturnData(0,false);
        }
        return new ReturnData(Math.max(leftDa.val,rightDa.val)+1,true);
    }
}
