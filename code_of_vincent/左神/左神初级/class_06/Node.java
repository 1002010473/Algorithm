package 左神.左神初级.class_06;

import java.util.ArrayList;

public class Node {
	public int value;
	public int in;//入度：有多少节点指向我
	public int out;//出度：我指向多少节点
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
