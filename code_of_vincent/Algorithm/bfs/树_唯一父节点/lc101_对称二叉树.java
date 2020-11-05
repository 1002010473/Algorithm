package Algorithm.bfs.树_唯一父节点;

import Algorithm.TreeNode;

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
        return method(root, root);
    }
    //层序遍历
    public static boolean method(TreeNode m, TreeNode n){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(m);
        queue.addLast(n);
        while(!queue.isEmpty()){
            //如果队列为空，方法执行将会报错，但是，由于我们在放置节点是一直保持了双数放入，所以不会出现报错的情况
            TreeNode pre =  queue.removeFirst();
            TreeNode aft = queue.removeFirst();
            if(pre == null && aft == null){
                continue;
            }else if(pre == null || aft == null){
                return false;
            }else if(pre.val != aft.val){
                return false;
            }
            //此时，能走到这里的就只有val相等的非空节点
            queue.addLast(pre.left);
            queue.addLast(aft.right);
            queue.addLast(pre.right);
            queue.addLast(aft.left);
        }
        return true;
    }
    //递归实现
    public boolean method1(TreeNode roota,TreeNode rootb){
        if(roota==null && rootb==null){return true;}
        if(roota==null || rootb==null){
            return false;
        }
        if(roota.val != rootb.val) return false;
        return method1(roota.left,rootb.right) && method1(roota.right,rootb.left);
    }
}
