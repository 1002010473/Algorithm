package test;



/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/28 18:51
 */
public class Main2 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        System.out.println(method(a));
    }
    public static int method(TreeNode root){
        if(root == null) return 0;
        int left = method(root.left);
        int right = method(root.right);
        int res = Math.max(left, right) + 1;
        return res;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
