package Algorithm.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 和上一题类似，没采用将newInterval放置到二维数组中去的方法，而是采用效率更高的，只针对
 * 重叠部分的interval采取比较合并
 * @author: 文琛
 * @time: 2020/6/29 10:43
 */
public class lc57_插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> lists = new ArrayList<>();
        int i = 0;
        //先把小于的放进去
        while(i < intervals.length && intervals[i][0] < start){
            lists.add(intervals[i++]);
        }
        //结合前面的end值处理
        if(lists.size() == 0 || start > intervals[i-1][1]){
            //打开一个新的interval
            int[] arr = new int[2];
            arr[0] = start;
            while(i < intervals.length && end >= intervals[i][0]){
                end = Math.max(intervals[i++][1], end);
            }
            arr[1] = end;
            lists.add(arr);
        }else{
            //更新已经放入lists中的最后的end值即可
            if(end <= intervals[i-1][1]){
                return intervals;
            }else{
                int k = intervals[i-1][0];
                while(i < intervals.length && end >= intervals[i][0]){
                    end = Math.max(intervals[i++][1], end);
                }
                lists.set(lists.size()-1, new int[]{k, end} );
            }
        }
        while(i < intervals.length){
            lists.add(intervals[i++]);
        }
        int[][] res= new int[lists.size()][2];
        for(int j = 0; j < res.length; j++){
            res[j] = lists.get(j);
        }
        return res;
    }
}
