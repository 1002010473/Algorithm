package ToOffer.ten;

import DataStructure.BinaryTreeNode;

public class Seven {
    public static void main(String[] args) {
        int [] pre= {1,2,4,7,3,5,6,8};
        int [] in= {4,7,2,1,5,3,8,6};
        BinaryTreeNode no = reBuildTree(pre, in);
        no.printTree();

    }
    private static BinaryTreeNode reBuildTree(int[] preorder,int [] inorder){
        BinaryTreeNode root = reBuildTree(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
        return root;
    }
    private static BinaryTreeNode reBuildTree(int[] preorder, int startPre, int endPre,
                                               int[] inorder, int startIn, int endIn){
        if (startPre > endPre || startIn > endIn)
            return null;
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = preorder[startPre];
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == preorder[startPre]) {
                root.leftNode = reBuildTree(preorder, startPre + 1, startPre + i - startIn, inorder, startIn, i - 1);
                root.rightNode = reBuildTree(preorder, startPre + i - startIn + 1, endPre, inorder, i + 1, endIn);
            }
        }
        return root;
    }
}
