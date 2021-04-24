package Algorithm.twopointers.seq;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/15 10:26
 */
public class lc11_盛最多水的数组容器 {
    //双指针 -- 推荐  证明见官方题解 -- 从较小的边界分析入手---状态消去
    public int maxArea(int[] height) {
        //双指针
        int len = height.length;
        int left = 0, right = len - 1;
        int res = 0;
        while(left < right){
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
    //单调栈 -- 勉强通过
    public int maxArea1(int[] height) {
        //尝试使用单调栈--从前往后的单调减
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        int max = 0;
        for(int i = len - 1; i >= 0; i--){
            //计算面积最大值
            for(int index : stack){
                max = Math.max(max, (index - i) * Math.min(height[i], height[index]));
            }
            //将自己放入
            if(stack.isEmpty() || height[i] > height[stack.peekLast()])
                stack.addLast(i);
        }
        return max;
    }
}
