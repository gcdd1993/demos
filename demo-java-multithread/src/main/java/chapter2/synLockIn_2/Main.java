package chapter2.synLockIn_2;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Main {
    public int i = 10;
    synchronized public void operateIMainMethod() {
        try {
            i--;
            System.out.println("main print i = " + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
