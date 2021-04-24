package Algorithm.DFS.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 和上题不同，不再返回true or false； 而是返回路径上的节点
 * 继续DFS
 * @author: 文琛
 * @time: 2020/7/2 10:02
 */
public class lc113_路径总和2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;
        List<Integer> list = new ArrayList<>();
        method(root, sum, list, lists);
        return lists;
    }
    public void method(TreeNode node, int sum, List<Integer> list, List<List<Integer>> lists){
        if(node == null)
            return;
        list.add(node.val);
        if(node.left == null && node.right == null){
            if(node.val == sum){
                List<Integer> l = new ArrayList<>(list);
                lists.add(l);
            }
        }
        method(node.left, sum - node.val, list, lists);
        method(node.right, sum - node.val, list, lists);
        list.remove(list.size()-1);
    }

}
