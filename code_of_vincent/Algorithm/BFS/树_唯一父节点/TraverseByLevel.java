package Algorithm.BFS.树_唯一父节点;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树层序遍历 递归 (DFS) + 非递归（BFS）
 * BFS
 * BFS使用队列，把每个还没有搜索遍历到的点依次放入队列，然后弹出队列的头部元素当做当前遍历点。BFS共有两个模板：
 *
 * 1 如果不需要确定当前遍历到了哪一层，BFS模板如下。
 * while queue 不空：
 *     cur = queue.pop()
 *     for 节点 in cur的所有相邻节点：
 *         if 该节点有效且未访问过：
 *             queue.push(该节点)
 *
 * 2 如果要确定当前遍历到了哪一层，BFS模板如下。
 *   这里增加了level表示当前遍历到的层数，也可理解为在一个图中，现在走了多少步。size表示在当前遍历层元素个数
 *   也就是队列中的元素数，我们把这些元素一次性遍历完，即把当前层的所有元素都向外走了一步。
 * level = 0
 * while queue 不空：
 *     size = queue.size()
 *     while (size --) {
 *         cur = queue.pop()
 *         for 节点 in cur的所有相邻节点：
 *             if 该节点有效且未被访问过：
 *                 queue.push(该节点)
 *     }
 *     level ++;
 *DFS
 *
 * @author: 文琛
 * @time: 2020/6/15 9:53
 */
public class TraverseByLevel {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        method1(root);
        method2(root);
        method3(root);
    }

    //迭代 ：套BFS模板1(不需要确定层数，顺序打印即可)
    private static void method1(TreeNode root) {
        System.out.println("不分层迭代遍历：");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            System.out.print(node.val + " ");
            if(node.left != null) queue.addLast(node.left);
            if(node.right != null) queue.addLast(node.right);
        }
        System.out.println();
    }
    //迭代：套BFS模板2（分层遍历打印）
    private static void method2(TreeNode root) {
        System.out.println("分层迭代遍历：");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.removeFirst();
                System.out.print(node.val + " ");
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
                size --;
            }
            System.out.println();
        }
    }
    //递归：DFS
    private static void method3(TreeNode root) {
        System.out.println("分层递归遍历：");
        if(root == null)
            return;
        List<List<Integer>> list = new ArrayList<>();
        fun3(root, 1, list);
        for(List<Integer> l : list){
            for(int i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void fun3(TreeNode root, int i, List<List<Integer>> list) {
        if(root == null)
            return;
        while(list.size() < i){
            List<Integer> l = new ArrayList<>();
            list.add(l);
        }
        list.get(i-1).add(root.val);
        fun3(root.left, i+1, list);
        fun3(root.right, i+1, list);
    }


}
