package Algorithm.DFS.BinaryTree;

/**
 * @description: Given a binary tree and an array,
 * the task is to find if the given array sequence is present as a root to leaf path in given tree.
 * @author: 文琛
 * @time: 2020/7/2 11:01
 */
public class GFG_给定路径是否存在 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        int[] nums = {1,2};
        System.out.println(method(root, nums, 0));
    }

    private static boolean method(TreeNode root, int[] nums, int index) {
        if(root == null)
            return false;
        if(root.val == nums[index]){
            if(index == nums.length-1){
                if(root.left == null && root.right == null){
                    return true;
                }else{
                    return false;
                }
            }else{
                return method(root.left, nums, index+1) || method(root.right, nums, index+1);
            }
        }else{
            return false;
        }



    }


}
