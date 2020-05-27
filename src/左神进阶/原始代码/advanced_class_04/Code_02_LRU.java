package 左神进阶.原始代码.advanced_class_04;

import java.util.HashMap;

public class Code_02_LRU {
	//节点 ： value的节点，只保存value信息
	public static class Node<V> {
		public V value;
		public Node<V> last;
		public Node<V> next;

		public Node(V value) {
			this.value = value;
		}
	}
	//双向链表：tail为经常使用的，优先级较高的节点，head相反
	public static class NodeDoubleLinkedList<V> {
		private Node<V> head;
		private Node<V> tail;

		public NodeDoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void addNode(Node<V> newNode) {
			if (newNode == null) {
				return;
			}
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode;
				newNode.last = this.tail;
				this.tail = newNode;
			}
		}
		//给定确认在该链表上的节点，将其移动到尾部
		public void moveNodeToTail(Node<V> node) {
			//当前节点已经在尾部：频繁访问，此时优先级已经最高，无需改动
			if (this.tail == node)
				return;
			//和普通节点稍微有些区别：头节点没有前节点
			//拆出来：只需要将前后关联节点的指针信息改动，cur节点的指针留待后面更新
			if (this.head == node) {
				this.head = node.next;
				this.head.last = null; // 将cur的next指向cur的指针置为null
			} else {
				node.last.next = node.next;
				node.next.last = node.last;
			}
			//更新cur上的指针
			node.last = this.tail;
			node.next = null;
			this.tail.next = node;
			this.tail = node;
		}

		public Node<V> removeHead() {
			if (this.head == null)
				return null;
			Node<V> res = this.head;
			if (this.head == this.tail) { //只有一个节点
				this.head = null;
				this.tail = null;
			} else { //多个节点：换头
				this.head = res.next;
				res.next = null;
				this.head.last = null;
			}
			return res;
		}

	}

	public static class MyCache<K, V> {
		//实现key到value节点（引用地址）的映射
		private HashMap<K, Node<V>> keyNodeMap;
		//实现value节点到key的映射 :
		//用于实现在删除最不常用节点时，根据链表中的value节点查找到对应的key，从而实现keyNodeMap的快速删除
		private HashMap<Node<V>, K> nodeKeyMap;
		//实现优先级
		private NodeDoubleLinkedList<V> nodeList;
		//指定cache大小
		private int capacity;

		public MyCache(int capacity) {
			if (capacity < 1) {
				throw new RuntimeException("should be more than 0.");
			}
			this.keyNodeMap = new HashMap<K, Node<V>>();
			this.nodeKeyMap = new HashMap<Node<V>, K>();
			this.nodeList = new NodeDoubleLinkedList<V>();
			this.capacity = capacity;
		}

		public V get(K key) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<V> res = this.keyNodeMap.get(key);
				this.nodeList.moveNodeToTail(res);
				return res.value;
			}
			return null;
		}

		public void set(K key, V value) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<V> node = this.keyNodeMap.get(key);
				node.value = value;
				this.nodeList.moveNodeToTail(node);
			} else {
				Node<V> newNode = new Node<V>(value);
				this.keyNodeMap.put(key, newNode);
				this.nodeKeyMap.put(newNode, key);
				this.nodeList.addNode(newNode);
				if (this.keyNodeMap.size() == this.capacity + 1) {
					this.removeMostUnusedCache();
				}
			}
		}

		private void removeMostUnusedCache() {
			//三个数据结构中都需要删除
			Node<V> removeNode = this.nodeList.removeHead();
			K removeKey = this.nodeKeyMap.get(removeNode);
			this.nodeKeyMap.remove(removeNode);
			this.keyNodeMap.remove(removeKey);
		}

	}

	public static void main(String[] args) {
		MyCache<String, Integer> testCache = new MyCache<>(3);
		testCache.set("A", 1);
		testCache.set("B", 2);
		testCache.set("C", 3);
		System.out.println(testCache.get("B"));
		System.out.println(testCache.get("A"));
		testCache.set("D", 4);
		System.out.println(testCache.get("D"));
		System.out.println(testCache.get("C"));
	}

}
