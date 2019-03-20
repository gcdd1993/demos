package chapter2.synBlockString;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("a","aa");
    }
}
