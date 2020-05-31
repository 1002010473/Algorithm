package 左神进阶.中三节;

import java.util.ArrayList;

public class SkipListTest {
    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list.size());
        System.out.println(list.contains(3));
        System.out.println(list.contains(2));
        System.out.println(list.getHead().value);
    }
}

class SkipListNode {
    /**
     * 因为head的value放的是null，所以要用Integer类型
     * value值是不会重复的
     */
    public Integer value;
    public ArrayList<SkipListNode> nextNodes;

    public SkipListNode(Integer value) {
        this.value = value;
        this.nextNodes = new ArrayList<>();
    }
}

class SkipList {
    private int maxLevel;
    private int size;
    private SkipListNode head;//head作为辅助结构，其node列表中存放的就是每一层的起始节点
    private static final double CHANCE = 0.5;//level增长的概率

    public SkipList() {
        // 一开始只产生到第0层
        maxLevel = 0;
        // head不算在size中
        size = 0;
        // head中数值为null
        head = new SkipListNode(null);
        // head的层数随maxLevel更新，第0层也算一层，所以head要在第0层留个后
        head.nextNodes.add(null);
    }

    public SkipListNode getHead() {
        return head;
    }

    /**
     * 添加值进SkipList
     * @param aimValue  要添加的值
     */
    public void add(Integer aimValue) {
        if (aimValue == null) {
            return;
        }

        // 先更新size
        size++;

        // 产生新值的层数
        int level = 0;
        while (Math.random() < CHANCE) {
            level++;
        }

        // 更新maxLevel以及head的层数
        while (maxLevel < level) {
            maxLevel++;
            head.nextNodes.add(null);
        }

        int val = maxLevel;
        SkipListNode curNode = head;

        // 若最大层数大于本节点的层数，从最高层开始找<=aimValue的最大值，高层好找
        // 找的是maxLevel到level+1层的
        // 只查询，使curnode更快的来到插入部位附近，不添加节点
        while (val > level) {
            curNode = findNext(aimValue, curNode, val);
            val--;
        }

        SkipListNode newNode = new SkipListNode(aimValue);

        // 从第level层到第0层，每一层中将值添加进去
        while (level >= 0) {
            curNode = findNext(aimValue, curNode, level);

            // 这两个顺序不能反，反了就是newNode自己指向自己了
            newNode.nextNodes.add(0, curNode.nextNodes.get(level));
            curNode.nextNodes.set(level, newNode);
            level--;
        }
    }

    /**
     * 从curNode开始，在level这层找到<=aimValue的最大值，大于的之前的那个  层内一直右移
     */
    private SkipListNode findNext(Integer aimValue, SkipListNode curNode, int level) {
        // 用nextNode的值与aimValue进行比较
        SkipListNode nextNode = curNode.nextNodes.get(level);
        while (nextNode != null) {
            if (aimValue.compareTo(nextNode.value) < 0) {
                break;
            }
            curNode = nextNode;
            nextNode = curNode.nextNodes.get(level);
        }
        return curNode;
    }

    public int size() {
        return size;
    }

    /**
     * SkipList中是否含aimValue这个值
     */
    public boolean contains(Integer aimValue) {
        SkipListNode node = find(aimValue);
        return node != null && node.value != null && node.value.compareTo(aimValue) == 0;
    }

    /**
     * 在整个SkipList中找到<=value的最大值，不一定是在最底层才找到
     */
    private SkipListNode find(Integer value) {
        return find(value, head, maxLevel);
    }

    private SkipListNode find(Integer aimValue, SkipListNode curNode, int level) {
        while (level >= 0) {
            curNode = findNext(aimValue, curNode, level);
            // curNode.value可能为null，head的value便为null
            if (curNode.value != null && curNode.value.compareTo(aimValue) == 0) {
                break;
            }
            level--;
        }
        return curNode;
    }

    public void remove(Integer aimValue) {
        if (!contains(aimValue)) {
            return;
        }

        size--;
        SkipListNode aimNode = find(aimValue);
        int level = maxLevel;
        SkipListNode curNode = head;

        // 该节点的所有层的连接都要移除
        while (level >= 0) {
            // 第maxLevel层到第aimNode.nextNodes.size()层走这部分
            if (level >= aimNode.nextNodes.size()) {
                curNode = findNext(aimValue, curNode, level--);
                continue;
            }

            // 第aimNode.nextNodes.size()-1层到第0层走下半部分
            // 找到aimNode的前沿节点curNode
            while (curNode.nextNodes.get(level).value.compareTo(aimValue) != 0) {
                curNode = curNode.nextNodes.get(level);
            }
            curNode.nextNodes.set(level, aimNode.nextNodes.get(level));
            level--;
        }

        // 更新maxLevel与head的nextNodes，head第0层的nextNode要保留一个
        while (maxLevel > 0 && head.nextNodes.get(maxLevel) == null) {
            head.nextNodes.remove(maxLevel);
            maxLevel--;
        }
    }
}
