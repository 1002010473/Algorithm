package Algorithm.data_struct.tree;

import org.junit.Test;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/17 15:50
 */
public class lc124_二叉树中的最大路径和 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        root.left = a;
        root.right = b;
        System.out.println(maxPathSum(root));
    }
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //尝试在遍历每个节点过程中，判断两个子节点和当前节点值 -- 结合 -- 后的max，包括跨节点
        method(root);
        return max;
    }
    public int method(TreeNode root){
        if(root == null) return 0;
        int leftGift = Math.max(method(root.left), 0); // 贡献值，如果做负贡献，抹掉即可
        int rightGift = Math.max(method(root.right), 0);
        int containsCur = root.val + Math.max(leftGift, rightGift);//返回的是以当前节点作为起始的向下max路径
        max = Math.max(max, leftGift + rightGift + root.val);
        return containsCur;
    }
}
