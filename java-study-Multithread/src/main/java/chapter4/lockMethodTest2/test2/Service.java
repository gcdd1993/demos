package chapter4.lockMethodTest2.test2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class Service {
    public ReentrantLock lock = new ReentrantLock();
    public Condition newCondition = lock.newCondition();
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
            System.out.println("有没有线程正在等待newCondition" + lock.hasWaiters(newCondition) + " 线程数是多少？" + lock.getWaitQueueLength(newCondition));
            newCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
