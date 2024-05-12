package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PrintAB {
    static class ThreadPrintA extends Thread  {
        @Override
        public void run() {
            lock.lock();
            while (num % 2 == 0) {
                System.out.print("A");
                num++;
            }
            lock.unlock();
        }
    }

    static class ThreadPrintB extends Thread  {
        @Override
        public void run() {
            lock.lock();
            while (num % 2 == 1) { //todo 问题： 存在很多空转，不断的获得锁、释放锁，只有成功的时候才打印，并没有线程间的协同
                System.out.print("B");
                num++;
            }
            lock.unlock();
        }
    }
    private static Lock lock = new ReentrantLock();
    private static int num;
    public static void main(String[] args) {
        new ThreadPrintA().start();
        new ThreadPrintB().start();
    }
}

