package chapter3.join_sleep_2.join_sleep_1;

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
                b.join();
                for(int i = 0;i<Integer.MAX_VALUE;i++) {
                    String newString = new String();
                    Math.random();
                }
                Thread.sleep(6000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
