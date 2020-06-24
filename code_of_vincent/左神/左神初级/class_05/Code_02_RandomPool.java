package 左神.左神初级.class_05;

import java.util.HashMap;
/*设计RandomPool结构
【题目】 设计一种结构， 在该结构中有如下三个功能：
insert(key)： 将某个key加入到该结构， 做到不重复加入。
delete(key)： 将原本在结构中的某个key移除。
getRandom()：等概率随机返回结构中的任何一个key。
【要求】 Insert、 delete和getRandom方法的时间复杂度都是O(1)

【思路】通过两个map来实现
一个map放置key--index，实现不重复加入功能
一个map放置index--key，实现等概率随机获取的功能---Math.random()等概率获取size范围内的index
删除功能的实现：不能直接删除，否则在删除点上出现漏洞，随机获取无法实现等概率
	删除思路：在删除时，将末尾的键值对更换到要删除的位置上，size--
*/
public class Code_02_RandomPool {

	public static class Pool<K> {
		private HashMap<K, Integer> keyIndexMap;
		private HashMap<Integer, K> indexKeyMap;
		private int size;

		public Pool() {
			this.keyIndexMap = new HashMap<K, Integer>();
			this.indexKeyMap = new HashMap<Integer, K>();
			this.size = 0;
		}
		//key发生重复时，不发生任何操作
		public void insert(K key) {
			if (!this.keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}

		public void delete(K key) {
			if (this.keyIndexMap.containsKey(key)) {
				int deleteIndex = this.keyIndexMap.get(key);
				int lastIndex = --this.size;
				K lastKey = this.indexKeyMap.get(lastIndex);
				//置换末尾和要删除位置上的键值对
				//1 将keyIndex上的 最后的key的index更换为要删除键值对的index
				this.keyIndexMap.put(lastKey, deleteIndex);
				//2 将indexKey上的 要删除的index上的key更新为最后的key
				this.indexKeyMap.put(deleteIndex, lastKey);
				this.keyIndexMap.remove(key);
				this.indexKeyMap.remove(lastIndex);
			}
		}

		public K getRandom() {
			if (this.size == 0) {
				return null;
			}
			int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
			return this.indexKeyMap.get(randomIndex);
		}

	}

	public static void main(String[] args) {
		Pool<String> pool = new Pool<String>();
		pool.insert("zuo");
		pool.insert("cheng");
		pool.insert("yun");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());

	}

}
