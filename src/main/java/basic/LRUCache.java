package basic;

import java.util.HashMap;

/**
 * LRU： Least Recently Used 最近最少使用：根据最近被使用的时间，离当前最远的数据优先被淘汰
 *
 * 实现： Map + 双向链表
 */
public class LRUCache {

    private int cacheSize;     //总容量
    private int currentSize;   //当前数量

    //map： 快速读、取
    private HashMap<Integer, CacheNode> nodes;

    //双向链表：记录缓存元素的顺序，以进行淘汰
    //head、tail
    private CacheNode head;
    private CacheNode tail;

    class CacheNode {
        CacheNode prev;
        CacheNode next;
        int key;
        int value;
    }

    public LRUCache(int cacheSize) {
        cacheSize = cacheSize;
        currentSize = 0;
        nodes = new HashMap<>(cacheSize);

    }

    public void set(Integer key, Integer value) {
        if (nodes.get(key) == null) { //添加新元素
            CacheNode node = new CacheNode();
            node.key = key;
            node.value = value;
            nodes.put(key, node);

            //移动到表头
            moveToHead(node);
            //进行lru操作
            if (currentSize > cacheSize)
                removeTail();
            else
                currentSize++;

        } else {
            //更新元素值
            CacheNode node = nodes.get(key);
            //移动到表头
            moveToHead(node);
            node.value = value;
        }

    }

    public int get(int key) {
        if (nodes.get(key) != null) {
            CacheNode node = nodes.get(key);
            moveToHead(node);
            return node.value;
        }
        return 0;
    }

    private void moveToHead(CacheNode node) {
        //链表中间的元素
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        //移动到表头
        node.prev = null;
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
        }

        head = node;

        //更新tail
        //node就是尾部元素
        if (tail == node) {
            //下移一位
            tail = tail.prev;
        }

        //缓存里就一个元素
        if (tail == null) {
            tail = node;
        }
    }

    private void removeTail() {
        if (tail != null) {
            nodes.remove(tail.key);
            if (tail.prev != null)
                tail.prev.next = null;
            tail = tail.prev;
        }
    }

}
