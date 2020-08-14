package Algorithm.data_struct.tree;

/**
 * @description:
 * 中序遍历，如果遍历中的元素递增，那么就是搜索二叉树
 * @author: 文琛
 * @time: 2020/2/22 22:48
 */
public class 判断二叉树是否是搜索二叉树 {
    //中序遍历
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)  return true;

        // 访问左子树
        if (!isValidBST(root.left))
            return false;

        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre)
            return false;

        pre = root.val;

        // 访问右子树
        return isValidBST(root.right);
    }
    //递归判断--将判断条件带入到递归过程中
    public boolean isValidBST1(TreeNode root) {
        if(root == null) return true;
        return method(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }
    public boolean method(TreeNode node, long left, long right){
        if(node == null) return true;
        int value = node.val;
        if(value > left && value < right){
            return method(node.left, left, Math.min(right, value)) && method(node.right, Math.max(left, value), right);
        }else{
            return false;
        }
    }
}
