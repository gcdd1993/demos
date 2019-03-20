package chapter3.joinLong;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class Test {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
//            thread.join(2000);
            Thread.sleep(2000);
            System.out.println(" end timer = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
