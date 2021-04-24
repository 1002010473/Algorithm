package Algorithm.DFS.BinaryTree;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/6/15 9:42
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
    public static TreeNode getTree(){
        TreeNode root =  new TreeNode(1);
        TreeNode a =  new TreeNode(2);
        TreeNode b =  new TreeNode(3);
        TreeNode c =  new TreeNode(4);
        TreeNode d =  new TreeNode(5);
        root.left = a;
        root.right = b;
        a.right = c;
        b.right = d;
        return root;
    }
}
