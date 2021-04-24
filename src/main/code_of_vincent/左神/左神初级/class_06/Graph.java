package 左神.左神初级.class_06;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	//方便在图中按照节点编号新建，查询节点
	public HashMap<Integer,Node> nodes; // key 编号 value 节点
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
