package forty;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import util.BinaryTreeNode;
import util.BinaryTreeNode_char;

/**
 * @description: 二叉树的序列化和反序列化 -- 分别实现
 *
 * 序列化的过程中要将空字符打印，以满足于反序列化的要求
 * @author: 文琛
 * @time: 2019/12/14 15:09
 */
public class ThirtySeven {
    private static int i=0;
    private static BinaryTreeNode_char root;

    public static void main(String[] args) {

        BinaryTreeNode a = new BinaryTreeNode(6);
        BinaryTreeNode b = new BinaryTreeNode(5);
        BinaryTreeNode c = new BinaryTreeNode(7);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(8);
        BinaryTreeNode f = new BinaryTreeNode(9);
        a.leftNode = b;
        b.leftNode = d;
        a.rightNode = c;
        b.rightNode = e;
        c.leftNode = f;
        a.printTree();//         中序 递归
        System.out.println();
        StringBuffer stringBuffer = new StringBuffer();
        Serialize(a,stringBuffer);
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.capacity());

        BinaryTreeNode_char no = Deserialize(stringBuffer);
        no.printTree();
    }

    private static BinaryTreeNode_char Deserialize(StringBuffer stringBuffer ) {

        if (stringBuffer.charAt(i)==',') {
            i++;
            return Deserialize(stringBuffer);
            //忽略‘，’即可
        }
        if (stringBuffer.charAt(i)=='$') {
            i++;
            return null;
        }
        BinaryTreeNode_char node = new BinaryTreeNode_char();
        node.value = stringBuffer.charAt(i);
        i++;
        node.leftNode = Deserialize(stringBuffer);
        node.rightNode = Deserialize(stringBuffer);
        root = node;


        return root;
    }

    private static void Serialize(BinaryTreeNode root,StringBuffer stringBuffer) {

        if (root==null) {
            stringBuffer.append("$"+",");
            //stringBuffer.append("$");
        }else {
            stringBuffer.append(root.value+",");
            //stringBuffer.append(root.value);
            /*if (root.leftNode!=null){
                Serialize(root.leftNode);
            }
            if (root.rightNode!=null){
                Serialize(root.rightNode);
            }*/
            Serialize(root.leftNode,stringBuffer);
            Serialize(root.rightNode,stringBuffer);

        }

        /*return stringBuffer.toString();*/
    }
}
