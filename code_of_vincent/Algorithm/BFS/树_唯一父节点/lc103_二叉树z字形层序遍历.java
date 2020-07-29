package Algorithm.BFS.树_唯一父节点;

import java.util.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/6/15 10:51
 */
public class lc103_二叉树z字形层序遍历 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        List<List<Integer>> lists = zigzagLevelOrder(root);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i + " ");
            }
        }
    }
    //BFS模板1
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
                size--;
            }
            lists.add(list);
        }
        for(int i = 1; i < lists.size(); i+=2){
            Collections.reverse(lists.get(i));
        }
        return lists;
    }

}
