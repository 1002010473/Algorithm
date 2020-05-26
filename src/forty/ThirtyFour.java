package forty;

import util.BinaryTreeNode;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

/**
 * @description:二叉树中 和的值为某一值的路径
 * @author: 文琛
 * @time: 2019/12/13 22:20
 */
public class ThirtyFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int sum = scanner.nextInt();
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
        a.printTree();
        System.out.println();
        findPath(a,sum);
    }

    private static void findPath(BinaryTreeNode root, int sum) {
        if (root==null) return ;
        Stack<BinaryTreeNode> stack = new Stack<>();
        int currentSum = 0;
        findPath(root,sum,currentSum,stack);
    }

    private static void findPath(BinaryTreeNode root, int expectedSum, int currentSum, Stack<BinaryTreeNode> stack) {
        currentSum+=root.value;
        stack.push(root);
        if (currentSum==expectedSum&&root.leftNode==null&&root.rightNode==null){
            System.out.println("A path is found:");
            printStack(stack);
        }
        if (root.leftNode!=null) findPath(root.leftNode,expectedSum,currentSum,stack);
        if (root.rightNode!=null) findPath(root.rightNode,expectedSum,currentSum,stack);
        stack.pop();
        currentSum= currentSum-root.value;

    }
    public static void printStack(Stack<BinaryTreeNode> stack){
        Stack<BinaryTreeNode> tempStack = new Stack<>();
        while(!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        while(!tempStack.isEmpty()){
            BinaryTreeNode node = tempStack.pop();
            System.out.println(node.value + " ");
            stack.push(node);
        }
    }
}
