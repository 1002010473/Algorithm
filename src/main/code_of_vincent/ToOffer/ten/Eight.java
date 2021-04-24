package ToOffer.ten;

import DataStructure.BinaryTreeNode_Dad;
import org.junit.Test;

public class Eight {

    public static BinaryTreeNode_Dad findNext(BinaryTreeNode_Dad node) {
        // 有右节点，找到右子树的最左节点
        if (node.right!= null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }

        // 无右节点，则向上遍历，直至找到节点为父节点的左子节点
        while(node.father != null) {
            if (node.father.left == node)
                return node.father;
            node = node.father;
        }
        return null;
    }
    @Test
    public void test(){
        BinaryTreeNode_Dad a = new BinaryTreeNode_Dad();
    }
    public static void main(String[] args) {
        // 建立一个二叉树节点的数组，并tree[i].value赋值
        BinaryTreeNode_Dad[] tree = new BinaryTreeNode_Dad[9];
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new BinaryTreeNode_Dad();
            tree[i].value = chars[i];
        }
        /*
         *        a
         *      /   \
         *     b     c
         *    / \   / \
         *   d   e  f  g
         *      / \
         *     h   i
         */
        // 左右节点关系
        tree[0].left = tree[1];
        tree[0].right = tree[2];
        tree[1].left = tree[3];
        tree[1].right = tree[4];
        tree[2].left = tree[5];
        tree[2].right = tree[6];
        tree[4].left = tree[7];
        tree[4].right = tree[8];
        // 父节点关系
        tree[1].father = tree[0];
        tree[2].father = tree[0];
        tree[3].father = tree[1];
        tree[4].father = tree[1];
        tree[5].father = tree[2];
        tree[6].father = tree[2];
        tree[7].father = tree[4];
        tree[8].father = tree[4];

        tree[0].printList();
        BinaryTreeNode_Dad next = findNext(tree[8]);
        if(next == null) System.out.println("null");
        else System.out.println("   +++"+next.value);
    }

}
