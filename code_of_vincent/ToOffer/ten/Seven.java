package ToOffer.ten;

import DataStructure.BinaryTreeNode;

/**
 * @description: 递归实现二叉树的重建
 * @param
 * @return:
 * @author: Vincent
 * @time: 2020/11/13 21:04
 */

public class Seven {
    public static void main(String[] args) {
        int [] pre= {1,2,4,7,3,5,6,8};
        int [] in= {4,7,2,1,5,3,8,6};
        BinaryTreeNode no = reBuildTree(pre, in);
        no.printTree();
    }

    private static BinaryTreeNode reBuildTree(int[] preorder,int [] inorder){
        BinaryTreeNode root = reBuildTree(preorder,0,preorder.length - 1,
                inorder,0,inorder.length - 1);
        return root;
    }

    private static BinaryTreeNode reBuildTree(int[] preorder, int sPre, int ePre,
                                               int[] inorder, int sIn, int eIn){
        if (sPre > ePre || sIn > eIn)
            return null;
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = preorder[sPre];
        for (int i = sIn; i <= eIn; i++) {
            if (inorder[i] == root.value) {
                root.leftNode = reBuildTree(preorder, sPre + 1, sPre + i - sIn, inorder, sIn, i - 1);
                root.rightNode = reBuildTree(preorder, sPre + i - sIn + 1, ePre, inorder, i + 1, eIn);
            }
        }
        return root;
    }
}
