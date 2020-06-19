package Algorithm.DFS.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 返回从根节点到叶子节点的所有路径
 * @author: 文琛
 * @time: 2020/6/18 15:48
 */
public class lc257_二叉树的所有路径 {
    public static void main(String[] args) {

    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null)
            return paths;
        StringBuilder sb = new StringBuilder();
        construct_paths(root, sb, paths);
        return paths;
    }

    private static void construct_paths(TreeNode root, StringBuilder sb, List<String> paths) {
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            paths.add(sb.toString());
        }else{
            sb.append("->");
            if(root.left != null){
                construct_paths(root.left, sb, paths);
            }
            if(root.right != null){
                construct_paths(root.right, sb, paths);
            }
        }
        //恢复原样
        while(sb.length() > len){
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;TreeNode(int x) { val = x; }
}
