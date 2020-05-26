package 左神初级.class_07;

import java.security.PrivateKey;
import java.util.Comparator;
import java.util.PriorityQueue;

/*一块金条切成两半， 是需要花费和长度数值一样的铜板的。 比如长度为20的 金条， 不管切成长度多大的两半， 都要花费20个铜
板。 一群人想整分整块金 条， 怎么分最省铜板？
	例如,给定数组{10,20,30}， 代表一共三个人， 整块金条长度为10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长
度60的金条分成10和50， 花费60 再把长度50的金条分成20和30，花费50 一共花费110铜板。
	但是如果， 先把长度60的金条分成30和30， 花费60 再把长度30金条分成10和20， 花费30 一共花费90铜板。
	输入一个数组， 返回分割的最小代价。*/


//思路：从下往上，通过小根堆挑选最小的两个值进行合并，再将该值放回到小根堆中去，直到堆的大小为1，此时就是结果
//对应： 8 -- 第4题

public class Code_02_Less_Money {

	public static int lessMoney(int[] arr) {
		//默认小根堆
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		//大根堆的实现
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
		}
		int sum = 0;
		while (minHeap.size() > 1) {
			int cur = minHeap.poll() + minHeap.poll();
			sum += cur;
			minHeap.add(cur);
		}
		return sum;
	}



	public static void main(String[] args) {
		// solution
		int[] arr = { 6, 7, 8, 9 };
		int[] arr1 = {10,20,30};
		System.out.println(lessMoney(arr));
		System.out.println(lessMoney(arr1));


		//int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

		/*// min heap
		PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
		for (int i = 0; i < arrForHeap.length; i++) {
			minQ1.add(arrForHeap[i]);
		}
		while (!minQ1.isEmpty()) {
			System.out.print(minQ1.poll() + " ");
		}
		System.out.println();

		// min heap use Comparator
		PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComparator());
		for (int i = 0; i < arrForHeap.length; i++) {
			minQ2.add(arrForHeap[i]);
		}
		while (!minQ2.isEmpty()) {
			System.out.print(minQ2.poll() + " ");
		}
		System.out.println();

		// max heap use Comparator
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxheapComparator());
		for (int i = 0; i < arrForHeap.length; i++) {
			maxQ.add(arrForHeap[i]);
		}
		while (!maxQ.isEmpty()) {
			System.out.print(maxQ.poll() + " ");
		}*/

	}

	/*public static class MinheapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2; // < 0  o1 < o2  负数
		}

	}

	public static class MaxheapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1; // <   o2 < o1
		}

	}*/

}
