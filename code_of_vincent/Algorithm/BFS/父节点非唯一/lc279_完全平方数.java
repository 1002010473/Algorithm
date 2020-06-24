package Algorithm.BFS.父节点非唯一;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 此题目完全可以通过dp求解，此处另加尝试，使用BFS进行尝试
 * 给定正整数n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于n。
 * 你需要求组成n的完全平方数的最小个数。
 * @author: 文琛
 * @time: 2020/6/15 15:22
 */
public class lc279_完全平方数 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(method1(n));
    }
    //BFS:广度优先遍历，最小平方数的组合个数 == 最小步数，此处标记的是求和目标n
    //比dp快
    private static int method1(int n) {
        boolean[] flags = new boolean[n+1];
        Deque<Integer> queue = new LinkedList<>();
        queue.add(n);
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int target = queue.removeFirst();
                if(target == 0)
                    return steps;
                for(int j = 1; j * j <= target; j++){
                    int num = target - j * j;
                    if(!flags[num]) {
                        queue.addLast(num);
                        flags[num] = true;
                    }
                }
            }
            steps++;
        }
        return n;
    }
}
