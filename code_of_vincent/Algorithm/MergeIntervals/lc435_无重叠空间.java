package Algorithm.mergeIntervals;

import java.util.Arrays;

/**
 * @description: 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠
 * ps:左神会议安排问题--贪心
 * @author: 文琛
 * @time: 2020/6/29 14:14
 */
public class lc435_无重叠空间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        //调度问题，贪心算法：贪结束时间
        int len = intervals.length;
        if(len < 2)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= end){
                count++;
                end = intervals[i][1];
            }
        }
        return len - count;
    }
}
