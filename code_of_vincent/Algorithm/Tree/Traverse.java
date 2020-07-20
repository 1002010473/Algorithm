package Algorithm.Tree;

import DataStructure.BinaryTreeNode;

import java.util.*;

/**
 * @description:二叉树的三种遍历的六种实现 前序遍历 中序遍历 后序遍历---对应的是根节点的位置
 *重点难点 ： 非递归的实现
 * 其中： 先序 最简单 中序遍历稍复杂，先序和中序的遍历过程中都经过父节点两次 -- 后序遍历只能经过一次，较为困难--
 *      因此 后序遍历通过增加两个栈实现，是在先序遍历的基础上进行的变更---辅助栈实现打印顺序的反转（先序遍历--中左右==变更左右压栈顺序--中右左==压入第二个栈中进行反转--左右中）
 *      二叉树用递归非常方便===递归方法会经过二叉树中节点三次！！！！
 *
 * @author: 文琛
 * @time: 2019/12/9 9:06
 */
public class Traverse {
    static List<List<Integer>> levList;
    public static void main(String[] args) {
        BinaryTreeNode a = BinaryTreeNode.BSTFactory();
        a.printTree();//         中序 递归 （未传入参数的递归）
        System.out.println();
        midPrintTree(a);//       中序 递归（传参）
        System.out.println();
        PrintTree_(a);//         中序 循环
        System.out.println();
        System.out.println();
        frontPrintTree(a);//     前序 递归
        System.out.println();
        frontPrintTree_(a);//    前序 循环
        System.out.println();
        System.out.println();
        endPrintTree(a);//       后序 递归
        System.out.println();
        endPrintTree_(a); //     后序 循环
        System.out.println();

        System.out.println("层序 递归 实现");
        levelPrintTree(a);  //    层序 递归
        for (List<Integer> list : levList) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
    //层序遍历递归实现
    private static void levelPrintTree(BinaryTreeNode root) {
        levList = new ArrayList<List<Integer>>();
        print(root,1);
    }

    private static void print(BinaryTreeNode root, int i) {
        if(root == null)
            return;
        if(levList.size()<i) {
            List<Integer> list = new ArrayList<>();
            levList.add(list);
        }
        levList.get(i-1).add(root.value);
        print(root.leftNode,i+1);
        print(root.rightNode,i+1);
    }

    //递归实现
    private static void midPrintTree(BinaryTreeNode root) {
        if(root == null)
            return;
        midPrintTree(root.leftNode);
        System.out.print(root.value+" ");
        midPrintTree(root.rightNode);
    }
    private static void frontPrintTree(BinaryTreeNode root) {
        if(root == null )
            return ;
        System.out.print(root.value+" ");
        frontPrintTree(root.leftNode);
        frontPrintTree(root.rightNode);
    }
    private static void endPrintTree(BinaryTreeNode root) {
        if(root == null)
            return ;
        endPrintTree(root.leftNode);
        endPrintTree(root.rightNode);
        System.out.print(root.value+" ");
    }
    //非递归实现
    private static void frontPrintTree_(BinaryTreeNode root) {
        //先序遍历 非递归--利用栈结构实现节点回溯
        System.out.print("pre-order-非递归：");
        if(root == null)
            return;
        //栈--模拟实现一个节点经过两次--将right节点放置在栈中的合适位置(并没有回到之前的节点，但是可以找到rightnode，所以是模拟实现）
        Deque<BinaryTreeNode> stack = new LinkedList<>();
        stack.addFirst(root);//removeFirst--先进先出
        while(!stack.isEmpty()){
            root = stack.removeFirst();
            System.out.print(root.value+" ");
            if(root.rightNode != null)
                stack.addFirst(root.rightNode);//先压入右节点，这样先弹出左节点
            if(root.leftNode != null)
                stack.addFirst(root.leftNode);
        }
    }

    private static void endPrintTree_(BinaryTreeNode root) {
        //后序遍历 非递归
        System.out.print("after-order-非递归：");
        if(root == null)
            return;
        Deque<BinaryTreeNode> stack1 = new LinkedList<>();
        Deque<BinaryTreeNode> stack2 = new LinkedList<>();//进行弹出顺序反转的辅助栈
        //按照先序遍历的结构，仅反转左右子节点的压入顺序
        stack1.addFirst(root);
        while(!stack1.isEmpty()){
            root = stack1.removeFirst();
            //并将1弹出的节点不再直接打印，而是压入辅助栈
            stack2.addFirst(root);
            if(root.leftNode != null)
                stack1.addFirst(root.leftNode);
            if(root.rightNode != null)
                stack1.addFirst(root.rightNode);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.removeFirst().value+" ");
        }
    }

    private static void PrintTree_(BinaryTreeNode root) { //模拟每个节点两次经过，在第二次（弹出的时候）打印
        System.out.print("mid-order-非递归：");
        if(root == null)
            return;
        Deque<BinaryTreeNode> stack = new LinkedList<>();
        //两次经过，第二次打印，那么第二次必须是当前node，而不能像前序遍历一样，保存rightnode
        //在循环过程中，不能只靠stack来判断是否停止，而要结合root的情况，因为在root上还要进行向右的移动
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.addFirst(root);
                root = root.leftNode;
            }else { //当前节点为空，弹出节点（空节点的父节点或祖先节点）,打印，并向节点的右子节点移动
                root = stack.removeFirst();
                System.out.print(root.value+" ");
                root = root.rightNode;
            }
        }
    }
}
