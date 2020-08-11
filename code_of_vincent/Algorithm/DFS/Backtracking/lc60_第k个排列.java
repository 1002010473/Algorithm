package Algorithm.DFS.Backtracking;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/11 14:32
 */
public class lc60_第k个排列 {
    //改进版本 -- 通过数学计算判断排列的个数，从而按需取舍，降低时间复杂度 -- 1ms
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n+1];//记录当前的索引的数是否被使用过
        StringBuilder sb = new StringBuilder();
        return dfs(sb, used, 0, n, k);
    }

    /**
     * @param sb        路径记录，每层的选择
     * @param used      数组的元素是否被使用过
     * @param depth     深度，也就是当前使用的元素的索引
     * @param n
     * @param k
     * @return 第k个排列
     */
    private String dfs(StringBuilder sb, boolean[] used, int depth, int n, int k) {
        if (depth == n) //触发出口条件，开始收集结果集
            return sb.toString();

        int cur = factorial(n - depth - 1);
        //每个选择对应排列数，例如在depth=0--没有元素时，此时选择1，那么剩下的部分的排列数就是n-1！
        for (int i = 1; i <= n; i++) {//顺序遍历
            if (used[i]) continue;//当前元素被使用过，做剪枝
            if (cur < k) {//当前的排列组合数小于k，说明就算这一层排完，也到不了第k个，剪枝跳过，并减去对应的派列数
                k -= cur;
                continue;
            }
            //cur的值小于k，此时结果就在i对应的子排列中
            sb.append(i);
            used[i] = true;//当前元素被使用过标记
            return dfs(sb, used, depth + 1, n, k);
        }
        return "not exist";
    }

    //返回n的阶乘，如3!=3*2*1=6
    private int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res *= n--;
        }
        return res;
    }



    //初始版本 -- dfs的顺序就是按照字典序的排列顺序，只需要在dfs遍历的过程中添加计数即可 -- 1000ms
    String s = null;
    int j = 0;
    public String getPermutation1(int n, int k) {
        //返回按照小数字优先的排列顺序就是了
        boolean[] flags = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        method(sb, k, flags);
        return s;
    }
    public void method(StringBuilder sb, int k, boolean[] flags){
        if(s != null) return;
        int len = flags.length - 1;
        if(sb.length() == len){
            if(++j == k)
                s = sb.toString();
        }
        for(int i = 1; i <= len; i++){
            if(!flags[i]){
                sb.append(i);
                flags[i] = true;
                method(sb, k, flags);
                flags[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            if(s != null) break;
        }
    }
}
