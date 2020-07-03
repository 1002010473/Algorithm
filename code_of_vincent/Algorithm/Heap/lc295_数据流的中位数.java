package Algorithm.Heap;

import java.util.PriorityQueue;

/**
 * @description: 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * @author: 文琛
 * @time: 2020/7/2 14:28
 */
public class lc295_数据流的中位数 {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
    }
}
class MedianFinder {
    PriorityQueue<Integer> minPQ;//保存较大值
    PriorityQueue<Integer> maxPQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        if(minPQ.isEmpty()){
            minPQ.add(num);
        }else{
            if(num <= minPQ.peek()){
                maxPQ.add(num);
            }else{
                minPQ.add(num);
            }
            int dif = maxPQ.size() - minPQ.size();
            if(dif > 1){ //值较小的部分数据量比较多
                minPQ.add(maxPQ.poll());
            }else if (dif < -1){
                maxPQ.add(minPQ.poll());
            }
        }
    }

    public double findMedian() {
        int minSize = maxPQ.size();
        int maxSize = minPQ.size();
        if(minSize == 0 && maxSize == 0){
            return 0;
        }
        if(minSize == 0)
            return minPQ.peek();
        if(minSize == maxSize){
            return  ((double)(maxPQ.peek() + minPQ.peek()) / 2);
        }else if (minSize > maxSize){
            return maxPQ.peek();
        }else{
            return minPQ.peek();
        }
    }
}
