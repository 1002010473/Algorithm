package Algorithm.DFS.BinaryTree;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/2 9:49
 */
public class lc112_路径之和 {
    //节点val有正有负，只有当遍历到叶子节点时才可以判断是否是一个满足条件的路径
    //如果来到了null，必然也已经遍历过了其父节点，该父节点如果是叶子节点，必然已经判断过了，这时return的结果不影响正确结果
    //如果不是叶子节点，肯定要return false；
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
