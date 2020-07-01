package Algorithm.BFS.树_唯一父节点;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树，返回其节点值自底向上的层次遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @author: 文琛
 * @time: 2020/7/1 10:14
 */
public class lc107_二叉树的层序遍历2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addFirst(root);
        while ( !queue.isEmpty() ) {
            //list for current level
            List<Integer> list = new ArrayList<>();
            // number of elements in the current level
            int length = queue.size();
            for(int i = 0; i < length; ++i) {
                TreeNode node = queue.removeFirst();
                // fulfill the current level
                list.add(node.val);
                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }
            // add into head
            levels.add(0, list);
        }
        return levels;
    }
}
