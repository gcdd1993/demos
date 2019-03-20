package chapter4.useConditionWaitNotifyOK;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await() {
        try {
            lock.lock();
            System.out.println(" await 时间为 " + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal 时间为 " + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
