package Other.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/4/19 16:59
 */
public class ApplicationHeap {
    public static void main(String[] args) {
        //小根堆
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        System.out.println(minHeap.peek());//1
        System.out.println(minHeap.poll());//1
        System.out.println(minHeap.peek());//2
        //大根堆 -- 重写比较器
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        System.out.println(maxHeap.peek());//3
        System.out.println(maxHeap.poll());//3
        System.out.println(maxHeap.peek());//2
    }
}
