package queue;

import java.util.*;

/**
 * Created by longyun on 2018/10/13.
 */
public class QueueArray {
    public static void main(String[] args) {
      LinkedList linkedList  = new LinkedList();

      ArrayDeque<Integer> queue = new ArrayDeque<>();
      queue.push(1);//入栈
      queue.push(2);
      int m = queue.pop();//出栈
      System.out.println("pop: " + m);

      queue = new ArrayDeque<>();
      queue.offer(1);//入队列
        queue.offer(2);
       m = queue.poll();//出队列
        System.out.println("poll: " + m);


    }
}
