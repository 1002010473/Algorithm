package Algorithm.bfs.树_唯一父节点;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:  最小深度---是从根节点到最近叶子节点的最短路径上的节点数量。
 * 只有root的情况下为1
 * @author: 文琛
 * @time: 2020/7/1 10:19
 */
public class lc111_二叉树的最小深度 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println(minDepth(root));
        System.out.println(minDepth1(root));
    }
    //BFS:非递归
    public static int minDepth(TreeNode root) {
        //层序遍历实现：碰到双null就返回
        if(root == null)
            return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 1;
        while(!queue.isEmpty()){
            int num = queue.size();
            for(int i = 0; i < num; i++){
                TreeNode node = queue.removeFirst();
                if(node.left == null && node.right == null)
                    return level;
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null)queue.addLast(node.right);
            }
            level++;
        }
        return level;
    }
    //DFS:递归
    public static int minDepth1(TreeNode root) {
        if(root == null)
            return 0;
        int l = minDepth1(root.left);
        int r = minDepth1(root.right);
        if(root.left != null && root.right != null){
            return Math.min(l, r) + 1;
        }else{
            return l + r + 1;
        }
    }

}
