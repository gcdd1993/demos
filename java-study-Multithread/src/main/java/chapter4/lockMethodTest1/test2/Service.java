package chapter4.lockMethodTest1.test2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class Service {
    public ReentrantLock lock = new ReentrantLock();
    public void serviceMethod1() {
        try {
            lock.lock();
            System.out.println("service method 1 getHoldCount = " + lock.getHoldCount());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
