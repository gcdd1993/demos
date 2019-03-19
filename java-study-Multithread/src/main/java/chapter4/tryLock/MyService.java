package chapter4.tryLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 方法 boolean try Locko的作用是,仅在调用时锁定未被另一个线程保持的情况下,才
 获取该锁定
 方法 boolean try Lock( ong timeout, Timeunit unit)的作用是,如果锁定在给定等待时
 间内没有被另一个线程保持,且当前线程未被中断,则获取该锁定。
 */
public class MyService {
    public ReentrantLock lock = new ReentrantLock();
    public void waitMethod() {
        try {
            if(lock.tryLock(3, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " get lock");
                Thread.sleep(10000);
            }else {
                System.out.println(Thread.currentThread().getName() + " not get lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
