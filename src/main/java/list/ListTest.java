package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by longyun on 2018/10/16.
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int a = list.get(1); //get() 索引查找

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(1);//入栈
        linkedList.push(2); //入栈
        print(linkedList);
        int m = linkedList.peekFirst();
        System.out.println("peekFirst: " + m);

        m = linkedList.peek();
        System.out.println("peek: " + m);

        int n = linkedList.pollFirst();
        System.out.println("pollFirst: " + n);
        print(linkedList);

        linkedList.addFirst(3);//入队列（链表头）
        linkedList.addFirst(4);
        linkedList.offer(5);//队列末尾
        print(linkedList);
        System.out.println("peekFirst: " + linkedList.peekFirst());

    }

    public static void print(LinkedList<Integer> linkedList){
        for (int num : linkedList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
