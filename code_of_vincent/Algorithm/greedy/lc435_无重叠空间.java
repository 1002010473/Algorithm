package Algorithm.greedy;

import java.util.Arrays;

/**
 * @description: 老题重做
 * @author: 文琛
 * @time: 2020/7/11 16:58
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
