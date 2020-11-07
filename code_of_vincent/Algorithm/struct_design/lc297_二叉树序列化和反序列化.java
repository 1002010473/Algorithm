package Algorithm.struct_design;

import Algorithm.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/11/7 20:24
 */
public class lc297_二叉树序列化和反序列化 {
    //BFS层序遍历 -- 采用循环的方式
    public static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(str.length() > 1)
                str.append(",");

            if(node == null){
                str.append("null");
            }else{
                str.append(node.val);
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        str.append("]");
        return str.toString();
    }

    //BFS对应的String转二叉树，难点在于将不规则的层序遍历结果转换为规则的二叉树，即找到节点对应的父节点
    //所以，为了实现该思路，将首位root以外的每两个字符作为一个单位进行考虑，因为在转String的过程中就是两个两个转的
    //而且，在转String的过程中，是将每个位置上的两个子节点加入到String中去，如果该节点为null，那么子节点也就没有
    //所以，在后续的反转中，其实是将每两个节点找对应位置添加到其子节点中，而且是层序！null节点，所以可以再通过一个queue实现
    public static TreeNode deserialize(String data) {
        String str = data.substring(1,data.length() - 1);
        String[] ss = str.split(",");
        int len = ss.length;
        if("null".equals(ss[0])) return null;
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        for(int i = 1; i < len; i += 2){
            String s1 = ss[i];
            String s2 = ss[i+1];
            TreeNode pre = queue.removeFirst();
            if(!s1.equals("null")){
                pre.left = new TreeNode(Integer.parseInt(s1));
                queue.addLast(pre.left);
            }
            if(!s2.equals("null")){
                pre.right = new TreeNode(Integer.parseInt(s2));
                queue.addLast(pre.right);
            }
        }
        return root;
    }

    //DFS
    // 重点在递归上
    public String serialize1(TreeNode root) {
        //DFS版本
        if(root == null){
            return "null,";
        }
        String l = serialize1(root.left);
        String r = serialize1(root.right);
        return root.val + "," + l + r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        String[] ss = data.split(",");
        Deque<String> queue = new LinkedList<>();
        for(String s : ss){
            queue.addLast(s);
        }
        TreeNode root = method(queue);
        return root;
    }

    public TreeNode method(Deque<String> queue){
        String s = queue.removeFirst();
        if(s.equals("null")){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = method(queue);
            node.right = method(queue);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        String s = serialize(root);
        TreeNode n = deserialize(s);
    }
}
