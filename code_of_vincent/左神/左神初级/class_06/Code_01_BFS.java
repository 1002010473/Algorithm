package 左神.左神初级.class_06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/*宽度优先遍历
* 节点是图中定义的节点
* */
public class Code_01_BFS {

	public static void bfs(Node node) {
		if (node == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		//用于防止节点重复---可能出现一个节点不只属于当前一层
		HashSet<Node> map = new HashSet<>();
		queue.add(node);
		map.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}

}
