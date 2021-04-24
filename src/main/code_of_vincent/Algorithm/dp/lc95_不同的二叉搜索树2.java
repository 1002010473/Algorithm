package Algorithm.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:该题的最重要思考点，以i为root，那么i左边的数字不会出现在i右子树
 * @author: 文琛
 * @time: 2020/8/14 9:10
 */
public class lc95_不同的二叉搜索树2 {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(9);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode.val);
        }
    }
    static Map<String, List<TreeNode>> map;
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0)
            return ans;
        map = new HashMap<>();
        return getAns(1, n);
    }

    private static List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = map.get(start + " " + end);
        if(ans != null){
            //System.out.println("map起作用了");还是可以起到作用的，不过在n比较小的情况下，没有
            return ans;
        }
        ans = new ArrayList<TreeNode>();
        //此时没有数字，将 null 加入结果中 -- 为了在后续的循环中实现子节点为null的遍历
        if (start > end) {
            ans.add(null);
            return ans;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = getAns(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = getAns(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        map.put(start + " " + end, ans);
        return ans;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
