package forty;

import util.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:二叉树的层级遍历（宽度优先）
 * @author: 文琛
 * @time: 2019/12/11 15:38
 */
public class ThirtyTwo {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(10);
        BinaryTreeNode b = new BinaryTreeNode(6);
        BinaryTreeNode c = new BinaryTreeNode(14);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(8);
        BinaryTreeNode f = new BinaryTreeNode(12);
        a.leftNode = b;
        b.leftNode = d;
        a.rightNode = c;
        b.rightNode = e;
        c.leftNode = f;
        a.printTree();// 中序遍历
        System.out.println();
        System.out.println("------");
        printCeng(a);
        System.out.println();
        System.out.println("------");
        printFenHang(a);
        System.out.println();
        System.out.println("------");
        printZhi(a);
    }

    private static void printZhi(BinaryTreeNode root) {
        if (root==null) return ;
        Stack<BinaryTreeNode> queue3 = new Stack<>();
        Stack<BinaryTreeNode> queue4 = new Stack<>();
        queue3.push(root);
        int toBeprint = 1;
        int nextLevel = 0;
        while (!queue3.isEmpty()||!queue4.isEmpty()){
            while (!queue3.isEmpty()){
                BinaryTreeNode temp = queue3.pop();
                System.out.print(temp.value+" ");

                if (temp.leftNode!=null){
                    queue4.add(temp.leftNode);

                }
                if (temp.rightNode!=null){
                    queue4.add(temp.rightNode);

                }
            }
            System.out.println();
            while (!queue4.isEmpty()){
                BinaryTreeNode temp = queue4.pop();
                System.out.print(temp.value+" ");
                if (temp.rightNode!=null){
                    queue3.add(temp.rightNode);
                }
                if (temp.leftNode!=null){
                    queue3.add(temp.leftNode);
                }
            }
            System.out.println();
        }
    }

    private static void printFenHang(BinaryTreeNode root) {
        if (root==null) return ;
        Queue<BinaryTreeNode> queue2 = new LinkedList<>();
        queue2.add(root);
        int nextLevel = 0;
        int toBePrinted= 1;
        while (!queue2.isEmpty()){
            BinaryTreeNode node = queue2.poll();
            System.out.print(node.value+" ");
            toBePrinted--;
            if (node.leftNode!=null){
                queue2.add(node.leftNode);
                nextLevel++;
            }
            if (node.rightNode!=null){
                queue2.add(node.rightNode);
                nextLevel++;
            }
            if (toBePrinted==0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel=0;
            }
        }

    }

    private static void printCeng(BinaryTreeNode root) {
        if (root==null) return;
        Queue<BinaryTreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty()){
            printCeng_(queue1);
        }
    }

    private static void printCeng_(Queue<BinaryTreeNode> queue) {
        BinaryTreeNode root = queue.poll();
        System.out.print(root.value+" ");
        if (root.leftNode!=null){
            queue.add(root.leftNode);
        }
        if (root.rightNode!=null){
            queue.add(root.rightNode);
        }
    }
}
