package chapter4.mustUseMoreCondition_ok;

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
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA 时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA 时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB 时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB 时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAllA() {
        try {
            lock.lock();
            System.out.println("signalAllA 时间为 " + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void signalAllB() {
        try {
            lock.lock();
            System.out.println("signalAllB 时间为 " + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
