package util;
/*二叉树*/
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    public BinaryTreeNode() { }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public void printTree(){
        if (leftNode != null){
            leftNode.printTree();
        }
        System.out.print(value+" ");
        if (rightNode != null){
            rightNode.printTree();
        }
    }

}
