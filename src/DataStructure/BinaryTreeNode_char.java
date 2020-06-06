package DataStructure;

/**
 * @description:
 * @author: 文琛
 * @time: 2019/12/16 15:02
 */
public class BinaryTreeNode_char {
    public char value;
    public BinaryTreeNode_char leftNode;
    public BinaryTreeNode_char rightNode;
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
