package chapter3.p_c_allWait;

import chapter3.p_r_test.ValueObject;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("")) {
                    System.out.println("consumer " + Thread.currentThread().getName() + " is waiting");
                    lock.wait();
                }
                System.out.println(" consumer " + Thread.currentThread().getName() + " is runnable");
                ValueObject.value = "";
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
