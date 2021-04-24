package Algorithm.data_struct.stack.单调stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/16 11:10
 */
public class lc84_柱状图中最大面积矩形 {
    //按层遍历计算， 超时
    public int largestRectangleArea(int[] heights) {
        //首先尝试按层遍历
        int len = heights.length;
        boolean flag = false;
        boolean[] flags = new boolean[len];
        int max = 0;
        for(int i : heights){
            max = Math.max(max, i);
        }
        int h = 1, res = 0;
        for(int k = 1; k <= max; k++){
            for(int i = 0; i < len; i++){
                int j = i;
                while(i < len && heights[i] >= k){
                    i++;
                }
                res = Math.max(res, (i - j) * k);
            }
        }
        return res;
    }
    //单调栈 -- 每个位置向前遍历的递减栈 -- 超时，但只剩一个
    public int largestRectangleArea1(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int len = heights.length;
        int res = 0;
        for(int i = 0; i < len; i++){
            //按照每个i作为起始位置入栈 -- 单调减
            stack.clear();
            int j = i;
            while(j < len){
                if(stack.isEmpty() || heights[j] <= stack.peekLast()){
                    stack.addLast(heights[j]);
                }else{
                    stack.addLast(stack.peekLast());
                }
                int size = stack.size();
                res = Math.max(res, size * stack.peekLast());
                j++;
            }
        }
        return res;
    }
    //按照柱高遍历，通过 -- 相当于确认以每个柱子为高度对应值，查找相关的矩形面积
    public int largestRectangleArea2(int[] heights) {
        int area = 0, n = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
            int w = 1, h = heights[i], j = i;
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            j = i;
            while (++j < n && heights[j] >= h) {
                w++;
            }
            area = Math.max(area, w * h);
        }
        return area;
    }
    //单调递增栈实现快速查找左右小于当前值的index
    public int largestRectangleArea3(int[] heights) {
        //首先将思路抓换到求最大面积，必然是某个柱子的水平延伸
        int len = heights.length;
        if(len < 1) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int[] count = new int[len];
        for(int j = len - 1; j >= 0; j--){
            while(!stack.isEmpty() && heights[stack.peekLast()] >= heights[j]){
                stack.removeLast();
            }
            if(stack.isEmpty()){
                count[j] = len;
            }else{
                count[j] = stack.peekLast();
            }
            stack.addLast(j);
        }
        stack.clear();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]){
                stack.removeLast();
            }
            if(stack.isEmpty()){
                count[i] -= -1;
            }else{
                count[i] -= stack.peekLast();
            }
            stack.addLast(i);
        }
        int res = 0;
        for(int i = 0; i < len; i++){
            res = Math.max(res, (count[i] - 1) * heights[i]);
        }
        return res;
    }
}
