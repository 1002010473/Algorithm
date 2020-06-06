package DataStructure;
/*二叉树结点类，包括左右子树，父节点，以及用于查看的函数*/
public class BinaryTreeNode_Dad {
    public char value;
    public BinaryTreeNode_Dad left;
    public BinaryTreeNode_Dad right;
    public BinaryTreeNode_Dad father;
    //中序遍历输出查看
    public void printList(){
        if (left!=null)  left.printList();
        System.out.println(value);
        if (right!=null) right.printList();
    }
}
