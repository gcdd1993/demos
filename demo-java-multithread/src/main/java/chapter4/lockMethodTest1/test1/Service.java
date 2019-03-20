package chapter4.lockMethodTest1.test1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class Service {
    private ReentrantLock lock = new ReentrantLock();
    public void serviceMethod1() {
        try {
            lock.lock();
            System.out.println("service method 1 getHoldCount = " + lock.getHoldCount());
            serviceMethod2();
        } finally {
            lock.unlock();
        }
    }
    public void serviceMethod2() {
        try {
            lock.lock();
            System.out.println("service method 2 getHoldCount = " + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }
}
