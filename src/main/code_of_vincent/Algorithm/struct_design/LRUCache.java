package Algorithm.struct_design;

import java.util.HashMap;
import java.util.Map;

/*O(1)时间复杂度内完成put 和 get（key， value）， 并且实现末位淘汰机制*/
//O1 主要由 hashmap 负责实现， 末尾淘汰通过双向链表实现
//为什么使用双向链表 -- 方便在删除尾部节点时，可以通过虚拟tail的pre获取尾部节点---如果是单向链表，尾节点的更新操作需要遍历
//为什么map中已经有key了，还在node中嵌入key--方便通过node获取key，从而实现map中对应的定位（例如removeTail）
public class LRUCache {
    private Map<Integer, DLinkedNode> map;
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) { //构造方法
        this.capacity = capacity;
        map  = new HashMap<>();
        size = 0;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode(); //头部最新
        tail = new DLinkedNode(); //尾部移除
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null)
            return -1;   //不存在，返回-1
        //先通过哈希表定位node，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) { // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) { // 如果超出容量，删除双向链表的尾部节点和hash表中的项
                DLinkedNode tail = removeTail();
                map.remove(tail.key);//node -> key -> map
                --size;
            }
        }
        else {
            //如果存在，先通过哈希表定位node，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) { //将node脱离出双向链表 --
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);//将脱离和置首分离开，方便removeTail复用
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;//双向链表存在的价值：迅速确定tail之前的节点
        removeNode(res);
        return res;
    }
}
class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode() {} //照顾 head 和 tail
    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}