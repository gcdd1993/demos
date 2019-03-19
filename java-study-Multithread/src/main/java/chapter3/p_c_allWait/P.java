package chapter3.p_c_allWait;

import chapter3.p_r_test.ValueObject;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class P {
    private String lock;

    public P(String lock) {
        this.lock = lock;
    }
    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("producer " + Thread.currentThread().getName() + " is waiting");
                    lock.wait();
                }
                System.out.println("producer " + Thread.currentThread().getName() + " is runnable");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = value;
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
