package 左神初级.class_06;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
/*最小生成树
P算法：稍微复杂一些
思路：见脑图
* */
// undirected graph only
public class Code_05_Prim {

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> primMST(Graph graph) {
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
				new EdgeComparator());
		HashSet<Node> set = new HashSet<>();
		Set<Edge> result = new HashSet<>();
		//for循环，是用来实现 并不是连通图时，尝试将所有节点都添加进来
		for (Node node : graph.nodes.values()) {
			if (!set.contains(node)) {
				set.add(node);
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);
				}
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll();
					Node toNode = edge.to;
					if (!set.contains(toNode)) {
						set.add(toNode);
						//to节点成功添加后才需要将edge添加到result的set里面去
						result.add(edge);
						for (Edge nextEdge : toNode.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
	}

}
