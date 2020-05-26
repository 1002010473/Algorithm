package Other.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/4/18 12:19
 */
public class TraverseByLevelPro {
    public static void main(String[] args) {
        //List<List<Integer>> res = levelOrder()
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //升级版层级遍历 -- 需要将每一层的节点进行区分
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while ( !queue.isEmpty() ) {
            // start the current level---新的一行
            List<Integer> list = new ArrayList<>();
            // number of elements in the current level -- 队列中现有元素，都属于当前行
            int length = queue.size();
            for(int i = 0; i < length; ++i) {  //通过length来控制只获取当前行内元素
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            // go to next level
            levels.add(list);
        }
        return levels;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
