package chapter3.test2;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class MyThread2 extends Thread {
    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始 notify time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束 notify time = " + System.currentTimeMillis());
        }
    }
}
