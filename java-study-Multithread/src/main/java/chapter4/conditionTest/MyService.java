package chapter4.conditionTest;

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
    private boolean hasValue = false;
    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                condition.await();
            }
            System.out.println("打印★");
            hasValue = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                condition.await();
            }
            System.out.println("打印☆");
            hasValue = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
