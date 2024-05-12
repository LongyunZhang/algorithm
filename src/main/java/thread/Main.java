package thread;

public class Main {
    private final Object lock = new Object();
    private static int num;

    private void print(int target) {
        for (int i = 0; i < 10; i++) { // 打印10次
            synchronized (lock) {
                while (num %3 != target) { // 多线程并发，不能用if，必须用while循环测试等待条件，避免虚假唤醒
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.printf("%d", target+1);
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        new Thread(()->{
            m.print(0);
        }).start();
        new Thread(()->{
            m.print(1);
        }).start();
        new Thread(()->{
            m.print(2);
        }).start();
    }
}
