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

    public static BinaryTreeNode BSTFactory(){
        BinaryTreeNode a = new BinaryTreeNode(10);
        BinaryTreeNode b = new BinaryTreeNode(6);
        BinaryTreeNode c = new BinaryTreeNode(14);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(8);
        BinaryTreeNode f = new BinaryTreeNode(12);
        BinaryTreeNode g = new BinaryTreeNode(16);
        a.leftNode = b;
        b.leftNode = d;
        a.rightNode = c;
        b.rightNode = e;
        c.leftNode = f;
        c.rightNode = g;
        return a;
    }

}
