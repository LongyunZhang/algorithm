package stack;

import java.io.Serializable;

/**
 * Created by longyun on 2018/10/12.
 */

public class StackList<T> implements Serializable {

    private class Node {
        private T data; //保存节点的数据
        private Node next; //指向下个节点的引用

        public Node() {
        }
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;  //栈顶指针
    private int size = 0;   //栈的长度

    public StackList() {
        top = null;
    }

    public StackList(T element) {
        top = new Node(element, null);
        size++;
    }

    public int size() {
        return size;
    }

    public void push(T element) {
        top = new Node(element, top);
        size++;
    }

    public T pop() {
        Node oldTop = top;
        top = top.next;
        oldTop.next = null;
        size--;
        return oldTop.data;
    }

    public T peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        top = null;//将栈所有元素赋为null
        size = 0;
    }

    public String toString() {
        //链栈为空链栈时
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = top; current != null; current = current.next) {
                sb.append(current.data.toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

}