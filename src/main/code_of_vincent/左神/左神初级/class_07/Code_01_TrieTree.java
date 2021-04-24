package 左神.左神初级.class_07;
/*
* 前缀树：可以实现字符串前缀相关功能--统计是否有以某string开头的字符串
* 								 统计以string开头的字符串的个数
* 								 统计string出现的次数
* */
public class Code_01_TrieTree {

	public static class TrieNode {
		//有多少字符串经历过当前节点
		public int path;
		//有多少字符串是以当前节点结尾的
		public int end;
		//后续节点--假设只有a-z（小写）出现
		//不为null则为存在后续节点
		public TrieNode[] nexts;

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			//根节点
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			//转换为字符数组
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.path++;
			}
			//最后节点，path和end都＋＋
			node.end++;
		}
		//
		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				//常规删除：沿途节点 path--，end--
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					//如果当前节点的path直接为0了，那么下面的节点可以直接删除
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}
		//查询word在前缀树中出现的次数
		public int search(String word) {
			if (word == null)
				return 0;
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			//返回end
			return node.end;
		}
		//查询pre在前缀树中作为前缀出现的次数
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));//0
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));//1
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));//0
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));//1
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));//0
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));//0
		System.out.println(trie.prefixNumber("zuo"));//3

	}

}
