package Algorithm.bfs.树_唯一父节点;

import Algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树，返回自底向上的层次遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 借鉴一下是list.add(0, list) 就行了
 * @author: 文琛
 * @time: 2020/7/1 10:14
 */
public class lc107_二叉树的层序遍历2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty() ) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for(int i = 0; i < length; ++i) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left != null)  queue.addLast(node.left);
                if (node.right != null)  queue.addLast(node.right);
            }
            levels.add(0, list);
        }
        return levels;
    }
}
