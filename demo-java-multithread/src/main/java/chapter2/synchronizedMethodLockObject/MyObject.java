package chapter2.synchronizedMethodLockObject;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyObject {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void methodB() {
        try {
            System.out.println("begin methodB threadName=" + Thread.currentThread().getName() + " begin time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
