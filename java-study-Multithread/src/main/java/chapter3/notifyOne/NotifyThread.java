package chapter3.notifyOne;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class NotifyThread extends Thread {
    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            notifyAll();
            //多次调用notify()方法唤醒了全部WAITING中的线程。
//            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
        }
    }
}
