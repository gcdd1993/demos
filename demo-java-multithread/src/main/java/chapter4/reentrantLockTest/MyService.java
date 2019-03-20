package chapter4.reentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    /**
     * 调用ReentrantLock对象的lock）方法获取锁，调用unlockO方法释放锁。
     */
    public void testMethod() {
        lock.lock();
        for(int i=0;i<5;i++) {
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " " + (i+1));
        }
        lock.unlock();
    }
}
