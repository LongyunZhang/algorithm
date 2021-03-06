package map;

/**
 * Created by longyun on 2018/10/17.
 */

/**
 * 设计HashMap
 */
public class MyHashMap {
    final Bucket[] buckets = new Bucket[10000];

    public void put(int key, int value) {
        int i = idx(key);
        if (buckets[i] == null)
            buckets[i] = new Bucket();
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    public int get(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            return -1;
        ListNode node = find(buckets[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null) return;
        ListNode prev = find(buckets[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }


    /**
     * 获取索引
     * @param key
     * @return
     */
    int idx(int key) { return Integer.hashCode(key) % buckets.length;}

    ListNode find(Bucket bucket, int key) {
        ListNode node = bucket.head, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

class Bucket {
    final ListNode head = new ListNode(-1, -1);
}

class ListNode {
    int key;
    int val;

    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
