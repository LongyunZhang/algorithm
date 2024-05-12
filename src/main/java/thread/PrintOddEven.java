package thread;

/**
 * 交替打印 1-100
 */
public class PrintOddEven {
    private Object lock = new Object();
    private volatile int count;

    private void printOddEven() {
        synchronized (lock) {
            while (count < 10) {
                try {
                    System.out.print( Thread.currentThread().getName() + "：");
                    System.out.println(++count);
                    lock.notifyAll();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止count=10后，while()循环不再执行，有子线程被阻塞未被唤醒，导致主线程不能退出
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        PrintOddEven printOddEven = new PrintOddEven();
        new Thread(printOddEven::printOddEven, "odd").start();
        Thread.sleep(10); //为了保证线程odd先拿到锁
        new Thread(printOddEven::printOddEven, "even").start();
    }
}
