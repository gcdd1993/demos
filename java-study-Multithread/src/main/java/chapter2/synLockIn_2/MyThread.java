package chapter2.synLockIn_2;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateISubMethod();
    }
}
