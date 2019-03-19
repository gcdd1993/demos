package chapter4.readWriteLockBegin1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获取读锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
