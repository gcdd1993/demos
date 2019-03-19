package chapter4.lockMethodTest1.test3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class Service {
    private ReentrantLock lock = new ReentrantLock();
    private Condition newCondition = lock.newCondition();
    public void waitMethod() {
        try {
            lock.lock();
            newCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println("有" + lock.getWaitQueueLength(newCondition) + "个线程正在等待newCondition");
            newCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
