package Fifty;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 找出数据流中的中位数
 * 分析思路：
 * 用两个堆保存数据，保证两个堆的数据保持平衡
 * 1 元素个数相差不超过1）
 * 2 大顶堆存放的数据要比小顶堆的数据小
 * 3 当两个堆中元素为偶数个，将新加入元素加入到小顶堆，
 *   如果要加入的数据，比大顶堆的最大元素小，先将该元素插入大顶堆，然后将大顶堆的最大元素插入到小顶堆。
 *   实现方法中并没有进行比较，而是将数据直接插入到大顶堆，再将大顶堆中的最大值直接抛出，然后加入到小顶堆中。
 *  奇数个时，同理
 * @author: 文琛
 * @time: 2020/2/5 20:51
 */
public class FortyOne {
    //小顶堆，从小到大排列
    private PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    //大顶堆，从大到小的排列
    private PriorityQueue<Integer> max = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    //当前已插入的数据个数
    int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            max.offer(num);
            Integer curNum = max.poll();
            min.offer(curNum);
        } else {
            //如果为奇数
            min.offer(num);
            Integer curNum = min.poll();
            max.offer(curNum);
        }
        //插入一个数据后加1
        count++;
    }

    public Double GetMedian() {
        //返回中位数，除以2之后有可能出现小数，所以采用double
        if (count % 2 == 0) {
            return new Double(min.peek() + max.peek()) / 2;
        } else {
            return new Double(min.peek());
        }
    }

    public static void main(String[] args) {
        FortyOne fortyOne = new FortyOne();
        fortyOne.Insert(5);
        fortyOne.Insert(2);
        Double aDouble = fortyOne.GetMedian();
        System.out.println(aDouble);
    }
}

