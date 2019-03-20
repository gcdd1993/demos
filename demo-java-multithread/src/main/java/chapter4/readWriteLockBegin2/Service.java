package chapter4.readWriteLockBegin2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获取写锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
