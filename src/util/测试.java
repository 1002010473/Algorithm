package util;


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/3/16 10:37
 */
public class 测试 {
    private static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length==1) return root;
        int index =0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i]==preorder[0]){
                index = i;
            }
        }

        int[] pre1 = new int[index];
        int[] in1 = new int[index];
        for(int i = 0; i < pre1.length; i++){
            pre1[i] = preorder[i+1];
            in1[i] = inorder[i];
        }
        int[] pre2 = new int[inorder.length-1-index];
        int[] in2 = new int[inorder.length-1-index];
        for(int i = 0; i < in2.length;i++){
            pre2[i] = preorder[index+1];
            in2[i] = inorder[index+1];
        }
        root.left = buildTree(pre1,in1);
        root.right = buildTree(pre2,in2);
        return root;
    }

    public static void main(String[] args) {
        int[] aaa = {3,9,20,15,7};
        int[] bbb = {9,3,15,20,7};
        TreeNode treeNode = buildTree(aaa, bbb);
        int s = 1;
        int c = 6 & s;

        System.out.println("----" + c);

    }


}
