package chapter2.synLockIn_1;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}
