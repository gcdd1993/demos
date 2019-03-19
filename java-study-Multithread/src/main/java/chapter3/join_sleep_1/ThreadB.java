package chapter3.join_sleep_1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(" b run begin timer = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(" b run end timer = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void bService() {
        System.out.println("打印了 bService timer = " + System.currentTimeMillis());
    }
}
