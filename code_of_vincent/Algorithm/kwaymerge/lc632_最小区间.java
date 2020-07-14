package Algorithm.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/5 11:09
 */
public class lc632_最小区间 {
    public int[] smallestRange(List<List<Integer>> nums) {
        // K Way Merge
        int resl,resr;
        int left, right;
        //小根堆， 存放list中的坐标
        PriorityQueue<int[]> minP = new PriorityQueue<>((a,b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        //由于list有序，后序进入的必然是较大的值，所以只需要一个int来维护其最大值即可
        int max = Integer.MIN_VALUE;
        //为了初始化resl用
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) == null){
                return new int[2];
            }
            minP.add(new int[] {i, 0});
            max = Math.max(max, nums.get(i).get(0));
            min = Math.min(min, nums.get(i).get(0));
        }
        resl = min;
        resr = max;
        //更新res；
        while(minP.size() == nums.size()){
            int[] leftI = minP.poll();
            left = nums.get(leftI[0]).get(leftI[1]);
            right = max;
            if((right - left) < (resr - resl)){
                resl = left;
                resr = right;
            }
            if(leftI[1] < nums.get(leftI[0]).size()-1){
                leftI[1] = leftI[1]+1; // ++ 慎用啊
                minP.add(leftI);
                max = Math.max(max, nums.get(leftI[0]).get(leftI[1]));
            }
        }
        return new int[]{resl, resr};
    }
}
