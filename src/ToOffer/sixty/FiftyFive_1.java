package ToOffer.sixty;

import DataStructure.BinaryTreeNode;

/**
 * @description:递归实现求二叉树的深度
 * @author: 文琛
 * @time: 2020/2/13 22:05
 */
public class FiftyFive_1 {
    public int maxDepth(BinaryTreeNode root) {
        if(root==null){
            return 0;
        }
        int lDepth = maxDepth(root.leftNode);
        int rDepth = maxDepth(root.rightNode);
        return Math.max(lDepth,rDepth)+1;
    }

}
