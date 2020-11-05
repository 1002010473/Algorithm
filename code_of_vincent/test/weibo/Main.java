package test.weibo;

import java.util.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/13 16:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TreeNode> list = new ArrayList<>();
        String s = sc.nextLine();
        String[] ss = s.split(",");
        for(String str : ss){
            int i = Integer.parseInt(str);
            list.add(new TreeNode(i));
        }
        int len = list.size();
        for(int i = 0; i < len; i++){
            TreeNode node = list.get(i);
            int le = 2 * i + 1;
            int ri = 2 * i + 2;
            if(le < len){
                node.left = list.get(le);
            }
            if(ri < len){
                node.right = list.get(ri);
            }
        }
        //二叉树构建完毕
        TreeNode root = list.get(0);
        while(root != null && root.left != null){
            root = root.left;
        }
        //遍历处理
        reverse(list.get(0));
        //层序遍历打印
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> list1 = new ArrayList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            list1.add(node.val);
            if(node.left!= null) queue.addLast(node.left);
            if(node.right!= null) queue.addLast(node.right);
        }
        for(int i = 0; i < list1.size() - 1; i++){
            System.out.print(list1.get(i) + ",");
        }
        System.out.print(list1.get(list1.size() - 1));
    }

    private static void reverse(TreeNode node) {
        if(node == null) return;
        if(node.left != null) {
            reverse(node.left);
            node.left.right = node;
            node.left.left = node.right;
            node.left = null;
            node.right = null;
        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
