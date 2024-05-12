package thread;

// 两个线程交替打印1-100
public class Print100  {
    private final static Object lock = new Object();
    private static int num;
    static class PThread extends Thread {
        @Override
        public void run() {
            while (num <100){
                synchronized (lock) {
                    try {
                        System.out.println(++num);
                        lock.notify();
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    lock.notify(); //再次释放，避免有的线程一直处于wait后的等待对象池
                }
            }
        }
    }

    public static void main(String[] args) {
        new PThread().start();
        new PThread().start();
    }
}
