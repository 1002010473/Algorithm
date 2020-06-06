package 左神.左神初级;

import DataStructure.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * 层序遍历中进行情况的判断--
 * 遍历的当前节点有右子无左子：直接false
 * 在上一前提下，如果子树不全，那么该节点以后的节点必须为叶子节点
 * @author: 文琛
 * @time: 2020/2/22 22:49
 */
public class 判断完全二叉树0 {
    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeNode.BSTFactory();
        root.leftNode = null;
        boolean flag = method(root);
        System.out.println(flag);
    }

    private static boolean method(BinaryTreeNode root) {
        //层序遍历的逻辑实现基础
        Deque<BinaryTreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.removeFirst();
            //替换打印的逻辑：进行判断
            if(node.leftNode == null && node.rightNode != null){
                return false;
            }else{
                if(flag){//说明此时该节点只能是叶节点
                    if(node.leftNode != null || node.rightNode != null){
                        return false;
                    }
                }else{ //判断是否是 叶子节点都为空或者只有左子
                    if(node.rightNode != null){
                        //儿女双全
                    }else{
                        flag = true;
                    }
                }
            }
            if(node.leftNode != null)
                queue.addLast(node.leftNode);
            if(node.rightNode != null)
                queue.addLast(node.rightNode);
        }
        return true;
    }
}
