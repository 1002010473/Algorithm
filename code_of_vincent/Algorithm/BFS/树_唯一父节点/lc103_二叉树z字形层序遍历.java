package Algorithm.BFS.树_唯一父节点;

import java.util.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/6/15 10:51
 */
public class lc103_二叉树z字形层序遍历 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        List<List<Integer>> lists = zigzagLevelOrder(root);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i + " ");
            }
        }
    }
    //BFS模板2
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        queue.addLast(root);
        //int level = 0;
        while (!queue.isEmpty()){
            //level++;
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                /*if(level % 2 == 0){
                    if(node.left != null) queue.addLast(node.left);
                    if(node.right != null) queue.addLast(node.right);
                }else{
                    if(node.right != null) queue.addLast(node.right);
                    if(node.left != null) queue.addLast(node.left);
                }*/
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
                size--;
            }
            lists.add(list);
        }
        for(int i = 1; i < lists.size(); i+=2){
            int size = lists.get(i).size();
            int l = 0, r = size-1;
            while(l < r){
                exchange(lists.get(i), l++, r--);
            }
        }
        return lists;
    }

    private static void exchange(List<Integer> integers, int l, int r) {
        int tmp = integers.get(l);
        integers.set(l, integers.get(r));
        integers.set(r, tmp);
    }
}
