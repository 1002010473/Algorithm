package 左神初级.class_06;

public class Edge {
	public int weight;//权重
	public Node from;
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}
