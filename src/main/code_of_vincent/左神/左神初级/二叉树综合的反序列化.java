package 左神.左神初级;

/**
 * @description:
 * 将二叉树的整棵树序列化为String字符串的格式--中序 前序 后序 层序
 * null--以某个字符代替
 * 节点间的value之间 需要插入字符进行间隔标记
 *
 * @author: 文琛
 * @time: 2020/2/22 22:00
 */
public class 二叉树综合的反序列化 {
    //通过中序遍历和后序遍历结果确定二叉树
    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{2, 1}, new int[]{2, 1});
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        //递归实现
        int len = inorder.length;
        if(len == 0) return null;
        return method(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    public static TreeNode method(int[] inorder, int il, int ir, int[]postorder, int pl, int pr){
        if(il == ir)
            return new TreeNode(inorder[il]);
        if(il > ir) return null; //在循环的过程中，一般是在边界发生计算的时候出现越界，但是左右边界都是向对方靠近的，如果发生越界，肯定先出现边界倒置的情况
        int v = postorder[pr];
        int index = il;
        for(int i = il; i <= ir; i++){
            if(inorder[i] == v)
                index = i;
        }
        TreeNode root = new TreeNode(v);
        root.left = method(inorder, il, index - 1, postorder, pl, pl + index - il - 1);
        root.right = method(inorder, index + 1, ir, postorder, pl + index - il, pr - 1);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
