package chapter4.awaitUninterruptiblyTest2;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyService myService = new MyService();
            MyThread myThread = new MyThread(myService);
            myThread.start();
            Thread.sleep(3000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
