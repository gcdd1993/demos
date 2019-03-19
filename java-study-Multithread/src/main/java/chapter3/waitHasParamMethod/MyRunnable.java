package chapter3.waitHasParamMethod;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class MyRunnable {
    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin time = " + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end time = " + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    static private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify begin time = " + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end time = " + System.currentTimeMillis());
            }
        }
    };

    /**
     * 打印日志中wait begin的时间尾数为3879,在3000
     毫秒后, notify begin 6879被执行,也就是在此时间点准
     备对呈WAITING状态的线程进行唤醒。
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(runnable1);
        t.start();
        Thread.sleep(3000);
        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}
