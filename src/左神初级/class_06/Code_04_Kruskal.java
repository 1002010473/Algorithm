package 左神初级.class_06;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
/*最小生成树 ： 保证图所有节点保持联通的边，配合权重进行考量
从权重小的边进行考察----如果权重小，且添加完成后，不出现回路，那么即可选取，直至所有的点都连入图中
//回路的判断：并查集
 * */
//undirected graph only---前提是无向图
public class Code_04_Kruskal {

	// Union-Find Set
	public static class UnionFind {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> rankMap;//key ： 代表节点  value ： 代表节点所关联的节点数目

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		private Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> kruskalMST(Graph graph) {
		UnionFind unionFind = new UnionFind();
		unionFind.makeSets(graph.nodes.values());//初始化并查集，将所有的顶点放入到并查集当中去
		//PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a,b)->a.weight-b.weight);
		for (Edge edge : graph.edges) {
			priorityQueue.add(edge);
		}
		Set<Edge> result = new HashSet<>();
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			//拿边的from和to进行判断---是否属于一个集合（是否已经联通）
			if (!unionFind.isSameSet(edge.from, edge.to)) {
				result.add(edge);
				//edge添加进来，那么就要将from和to联通起来
				unionFind.union(edge.from, edge.to);
			}
		}
		return result;
	}
}
