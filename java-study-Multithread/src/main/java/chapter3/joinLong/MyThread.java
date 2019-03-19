package chapter3.joinLong;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("begin timer = " + System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
