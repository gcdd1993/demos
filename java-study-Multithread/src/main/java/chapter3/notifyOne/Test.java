package chapter3.notifyOne;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 *
 * 1.方法notify()仅随机唤醒一个线程。
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        ThreadB b = new ThreadB(lock);
        b.start();
        ThreadC c = new ThreadC(lock);
        c.start();
        Thread.sleep(1000);
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
    }
}
