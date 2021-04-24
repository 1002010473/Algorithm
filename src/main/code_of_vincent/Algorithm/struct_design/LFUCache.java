package Algorithm.struct_design;

import java.util.HashMap;
import java.util.Map;
/*请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。

get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
put(key, value) - 如果键存在，则变更其值；不存在，插入键值对。当达到容量时，在插入新项之前，使最不经常使用的项无效。
在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。
「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
在 O(1) 时间复杂度内执行两项操作

*/
public class LFUCache {
    private Map<Integer, LinkedNode> map;
    private int capacity;
    private int size;
    private LinkedNode head, tail;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        head = new LinkedNode();//从head到tail，使用次数依次递减
        tail = new LinkedNode();
        this.capacity = capacity;
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        LinkedNode node = map.get(key);
        if(capacity <= 0 || node == null)
            return -1;
        swim(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity <= 0) return;
        LinkedNode node = map.get(key);
        if(node == null){
            if(size == capacity){//去除最少使用的node
                removeTail();
                size--;
            }
            LinkedNode newNode = new LinkedNode(key, value);
            addToTail(newNode);
            map.put(key, newNode);
            size++;
            swim(newNode);
        }else{
            node.value = value;
            swim(node);
        }
    }

    private void swim(LinkedNode node){
        node.time = node.time + 1;
        int t = node.time;
        while(node.prev != head && t >= node.prev.time){ // 通过将相同time最近更新的向前移动，实现了同time下remove tail 就是 remove 不经常使用的目的
            LinkedNode pre = node.prev;
            pre.next = node.next;
            node.next.prev = pre;
            pre.prev.next = node;
            node.prev = pre.prev;
            node.next = pre;
            pre.prev = node;
        }
    }

    private void addToTail(LinkedNode node){
        LinkedNode last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }

    private void removeTail(){
        LinkedNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.remove(last.key);
    }
}
class LinkedNode {
    int key;
    int value;
    int time;
    LinkedNode prev;
    LinkedNode next;
    public LinkedNode() {}
    public LinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.time = 0;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */