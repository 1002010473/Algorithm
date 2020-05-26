package 左神初级.class_05;

import java.util.HashMap;
import java.util.List;
/*并查集
* 快速判断两个node是否在一个集合里面
*
*
*
* */
public class Code_04_UnionFind {

	public static class Node {
		// whatever you like
		//通过map维护关系，不需要指针的字段
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap; // key：child value : father
		public HashMap<Node, Integer> sizeMap; //key ：

		public UnionFindSet(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			makeSets(nodes);
		}

		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		//查找代表节点并压平
		//压平操作通过递归实现，就是将所有的串上的节点拆散并全部连接到代表节点上--非递归版本可通过压栈实现
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
