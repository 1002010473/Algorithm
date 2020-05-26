package 左神初级.class_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
* 拓扑排序：先找到in为0的节点，也就是不依赖其它节点的节点
* 适用于程序编译时存在依赖关系的处理，不被block
*
* */
public class Code_03_TopologySort {
	//拓扑排序的前提条件
	// directed graph and no loop
	public static List<Node> sortedTopology(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<>();
		Queue<Node> zeroInQueue = new LinkedList<>();
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}
		List<Node> result = new ArrayList<>();
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			result.add(cur);
			for (Node next : cur.nexts) {
				//将cur的next节点对应的in（入度）减一，相当于在图中移除了cur
				inMap.put(next, inMap.get(next) - 1);
				if (inMap.get(next) == 0) {
					zeroInQueue.add(next);
				}
			}
		}
		return result;
	}
}
