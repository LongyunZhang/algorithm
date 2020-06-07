package list;

/**
 * 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。——借助addAdIndex()实现
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。——借助addAdIndex()实现
 * addAtIndex(index,val)：在链表中的 第index个节点之前 添加值为val的节点。
 *                        如果index等于链表的长度，则该节点将附加到链表的末尾。
 *                        如果index大于链表长度，则不会插入节点。
 *                        如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 */
public class List707 {
    class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    Node head = null;
    Node tail = null;
    int length = 0;

    public List707() {};

    public int length() {
        return length;
    }

    //查找指定index的节点
    private Node findAtIndex(int index) {
        if (length == 0 || index > length - 1)
            return null;
        if (index <= 0)
            return head;

        Node result = head.next;
        int idx = 1;
        while (idx < index) {
            result = result.next;
            idx++;
        }
        return result;
    }

    //获取指定位置的结点（如果索引无效，返回-1）
    public int get(int index) {
        Node result = findAtIndex(index);
        return result != null ? result.value : -1;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    //在指定index的前边插入节点——借助findAtIndex()查找index-1节点
    public void addAtIndex(int index, int val) {
        if (index > length)
            return;

        Node nodeAtIndex = findAtIndex(index - 1);
        Node node = new Node(val);
        if (nodeAtIndex == null)//说明当前链表为null，head=node
            head = node;
        else if (index == 0) {//在head前插入节点
            node.next = head;
            head = node;
        } else {
            node.next = nodeAtIndex.next;
            nodeAtIndex.next = node;
        }

        length++;//链表长度+1
    }

    public void deleteAtIndex(int index) {
        if (length == 0 || index > length - 1 || index < 0)
            return;

        if (index == 0)//删除head节点
            head = head.next;
        else {
            Node nodeAtIndex = findAtIndex(index - 1);
            if (nodeAtIndex.next != null)
                nodeAtIndex.next = nodeAtIndex.next.next;
        }

        length--;//链表长度-1
    }

    public String toString() {
        String result = "";
        if (head == null)
            return result;

        Node node = head;
        while (node != null) {
            if (result == "")
                result += head.value;
            else
                result += "->" + node.value;
            node = node.next;
        }
        return result;
    }
}
