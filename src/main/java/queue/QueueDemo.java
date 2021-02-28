package queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        //入队列：add(E), offer(E) 在尾部添加:
        queue.add(1);   //add() 方法在添加失败（比如队列已满）时会报 一些运行时错误 错
        queue.offer(1);// offer() 方法即使在添加失败时也不会奔溃，只会返回 false

        //出队列：删除并返回头部
        queue.remove();//当队列为空时 remove() 方法会报 NoSuchElementException 错
        queue.poll();//poll() 不会奔溃，只会返回 null

        //获取队列头，不删除
        queue.element();//当队列为空时 element() 抛出异常
        queue.peek();//peek() 不会奔溃，只会返回 null


    }
}
