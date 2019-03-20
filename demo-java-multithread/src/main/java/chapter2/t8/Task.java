package chapter2.t8;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Task {
    synchronized public void otherMethod() {
        System.out.println("-------------------------run-otherMethod");
    }
    public void doLongTimeTask() {
        synchronized (this) {
            for(int i=0;i<100000;i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName() + " i = " + (i + 1));
            }
        }
    }
}
