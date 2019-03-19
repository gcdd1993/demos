package chapter2.twoStop;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Service {
    Object object1 = new Object();
    public void methodA() {
        synchronized (object1) {
            System.out.println("method a begin");
            boolean isContinueRun = true;
            while (isContinueRun) {}
            System.out.println("method a end");
        }
    }
    Object object2 = new Object();
    public void methodB() {
        synchronized (object2) {
            System.out.println("method b begin");
            System.out.println("method b end");
        }
    }
}
