package Algorithm.bfs.树_唯一父节点;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 树的遍历，由于每个节点只有唯一一个父节点，所以不存在重复遍历问题，无需boolean标识符
 * 递归 || 嵌套层序遍历
 * @author: 文琛
 * @time: 2020/6/15 9:40
 */
public class lc101_对称二叉树 {
    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.getTree()));

    }
    public static boolean isSymmetric(TreeNode root) {
        //两种方式（先左，先右）嵌套的层序遍历实现
        return method(root, root);
    }
    //层序遍历
    public static boolean method(TreeNode m, TreeNode n){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(m);
        queue.addFirst(n);
        while(!queue.isEmpty()){
            TreeNode left =  queue.removeFirst();
            TreeNode right = queue.removeFirst();
            if(left == null && right == null){
                continue;
            }else if(left == null || right == null){
                return false;
            }else{
                if(left.val != right.val){
                    return false;
                }
            }
            //此时，能走到这里的就只有val相等的非空节点
            queue.addLast(left.left);
            queue.addLast(right.right);
            queue.addLast(left.right);
            queue.addLast(right.left);
        }
        return true;
    }
}
