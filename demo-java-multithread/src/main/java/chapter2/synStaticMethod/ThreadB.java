package chapter2.synStaticMethod;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        Service.printB();
    }
}
