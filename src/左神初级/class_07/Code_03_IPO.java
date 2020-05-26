package 左神初级.class_07;

import java.util.Comparator;
import java.util.PriorityQueue;
/*输入： 参数1， 正数数组costs 参数2， 正数数组profits 参数3，正数k 参数4， 正数m
	costs[i]表示i号项目的花费
	profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
	k表示你不能并行、 只能串行的最多做k个项目
	m表示你初始的资金
说明： 你每做完一个项目， 马上获得的收益， 可以支持你去做下一个 项目。
输出： 你最后获得的最大钱数。*/

//思路：将项目进行对象封装，并且按照项目的花费进行小根堆排列初始化
//	   将m（在过程中会发生变化）作为比较对象，从小根堆内拿出所有小于该值的对象，放入到以项目的利润为依据的大根堆
//	   将大根堆的堆顶拿出，做它，获取项目利润
//	   循环，（拿到利润以后，m必然增大，所以所有项目只要出了小根堆，就相当于解锁了，不需要再回去，只要不断解锁即可）

// 对应 ： 8 -- 题目5
public class Code_03_IPO {
	//
	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	/*public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}

	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}*/

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Cost) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Cost[i]);
		}

		//PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
		//PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
		PriorityQueue<Node> minCostQ = new PriorityQueue<>((a,b)->a.c - b.c);
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>((a,b)->b.p - a.p);
		//初始化成本的小根堆
		for (Node node : nodes) {
			minCostQ.add(node);
		}
		for (int i = 0; i < k; i++) {
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
				maxProfitQ.add(minCostQ.poll());
			}
			//从成本的小根堆内获取所有成本小于W的项目后，大根堆还为空，说明W不够做任何的项目，或者是项目已经全部做完了，可以直接返回了
			if (maxProfitQ.isEmpty()) {
				return W;
			}
			W += maxProfitQ.poll().p;
		}
		return W;
	}

	public static void main(String[] args) {
		System.out.println(findMaximizedCapital(2,8,new int[]{5,2,3},new int[]{10,7,9}));
	}

}
