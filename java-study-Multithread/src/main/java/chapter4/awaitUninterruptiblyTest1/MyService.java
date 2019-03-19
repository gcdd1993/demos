package chapter4.awaitUninterruptiblyTest1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void testMethod() {
        try {
            lock.lock();
            System.out.println("wait begin");
            condition.await();
            System.out.println("wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("catch");
        } finally {
            lock.unlock();
        }
    }
}
