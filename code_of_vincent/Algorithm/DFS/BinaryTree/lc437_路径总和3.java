package Algorithm.DFS.BinaryTree;

/**
 * @description:  遍历每个节点，由于路径要求只能向下，所以在每个节点上method即可
 * @author: 文琛
 * @time: 2020/7/2 11:14
 */
public class lc437_路径总和3 {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        method1(root, sum);
        return res;
    }
    public void method1(TreeNode root, int sum){
        if(root == null)
            return;
        method(root, sum);
        method1(root.left, sum);
        method1(root.right, sum);
    }
    public void method(TreeNode root,int sum){
        if(root==null)
            return;
        if(root.val == sum)
            res++;
        method(root.left,sum-root.val);
        method(root.right,sum-root.val);
    }
}
