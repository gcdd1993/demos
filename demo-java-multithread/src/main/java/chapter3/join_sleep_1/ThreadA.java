package chapter3.join_sleep_1;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadA extends Thread {
    private ThreadB b;
    @Override
    public void run() {
        try {
            synchronized (b) {
                b.start();
                Thread.sleep(6000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
