package 左神进阶.前三节.单调栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/5/23 13:10
 */
public class MaxAreaOfMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0] = new int[]{1, 1, 1};
        arr[1] = new int[]{1, 0, 1};
        arr[2] = new int[]{1, 1, 1};
        System.out.println(method(arr));
    }
    public static int method(int[][] mtx){
        int[] start = new int[mtx[0].length];
        int max = 0;
        for(int i = 0; i < mtx.length; i++){
            for(int j = 0; j < start.length; j++){
                if(mtx[i][j] == 1){
                    start[j]++;
                }else{
                    start[j] = 0;
                }
            }
            int tmp = maxRecFromBottom(start);
            max = Math.max(max, tmp);
        }
        return max;
    }
    //通过单调栈(递增)实现按照数组值来计算最大矩形面积
    public static int maxRecFromBottom(int[] height){
        if(height == null || height.length == 0)
            return 0;
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peekLast()] > height[i]){
                int index = stack.pollLast();
                int r = i;
                int l = stack.isEmpty() ? -1 : stack.peekLast();
                //以每个弹出的index对应的height为基能够连续的矩形面积
                maxArea = Math.max(maxArea, height[index] * (r - l - 1));
            }
            stack.addLast(i);
        }
        //遍历完成后，栈中仍可能保留有未弹出的元素
        while(!stack.isEmpty()){
            int index = stack.pollLast();
            int r = height.length;
            int l = stack.isEmpty() ? -1 : stack.peekLast();
            maxArea = Math.max(maxArea, height[index] * (r - l - 1));
        }
        return maxArea;
    }
}
