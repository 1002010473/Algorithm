package Algorithm.bfs.树_唯一父节点;

import Algorithm.TreeNode;

import java.util.*;

public class lc199_二叉樹的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        //DFS層序遍歷，從右向左，並維護level，和list，在level > list.size()時擴充即可
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        method(root, 1, list);
        return list;
    }

    public void method(TreeNode node, int level, List<Integer> list){
        if(node == null) return;
        if(level > list.size()){
            list.add(node.val);
        }
        method(node.right, level+1, list);
        method(node.left, level+1, list);
    }
}
