package Algorithm.MergeIntervals;

import java.util.*;

/**
 * @description: 尝试将数组中的元素按照起始位置大小排序,然后将末尾位置值更新 merge1（）
 * metge借助栈可以实现更清晰的思路
 * @author: 文琛
 * @time: 2020/6/29 9:43
 */
public class lc56_合并区间 {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        if ((null == intervals) || (intervals.length == 0) )
            return new int[0][0];
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(intervals[0][0]);
        stack.addLast(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > stack.peekLast()) {
                stack.addLast(intervals[i][0]);
                stack.addLast(intervals[i][1]);
            } else if (intervals[i][1] > stack.peekLast()) {
                stack.removeLast();
                stack.addLast(intervals[i][1]);
            }
        }
        int arrSize = stack.size() / 2;
        int[][] result = new int[arrSize][2];
        int x = 0;
        while (!stack.isEmpty()) {
            result[x][0] = stack.removeFirst();
            result[x][1] = stack.removeFirst();
            x++;
        }
        return result;
    }
    public static int[][] merge1(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[0][0];
        if(intervals.length == 1)
            return intervals;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        //起始位置初始化
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1],end);//更新的是最大值
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                lists.add(list);
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if(i == intervals.length-1){//最后需要特殊处理
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                lists.add(list);
            }
        }
        int[][] res = new int[lists.size()][2];
        int j = 0;
        for(List<Integer> list : lists){
            res[j][0] = list.get(0);
            res[j++][1] = list.get(1);
        }
        return res;
    }
}
