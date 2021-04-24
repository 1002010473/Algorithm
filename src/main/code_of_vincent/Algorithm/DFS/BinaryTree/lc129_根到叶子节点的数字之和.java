package Algorithm.DFS.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/2 10:54
 */
public class lc129_根到叶子节点的数字之和 {
    //DFS1：不能传入一个int，只能传入一个对象
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        List<Integer> list = new ArrayList<>();
        int[] res = new int[1];
        method(root, list, res);
        return res[0];
    }
    public void method(TreeNode root, List<Integer> list, int[] res){
        if(root == null)
            return;
        list.add(root.val);
        if(root.left == null && root.right == null){
            int sum = 0;
            for(int i : list){
                sum *= 10;
                sum += i;
            }
            res[0] += sum;
        }
        method(root.left, list, res);
        method(root.right, list, res);
        list.remove(list.size()-1);
    }
    //DFS2：靠返回值
    public int sumNumbers1(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i){
        if (root == null)
            return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }
}
