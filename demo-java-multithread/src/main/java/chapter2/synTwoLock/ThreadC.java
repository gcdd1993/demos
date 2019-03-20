package chapter2.synTwoLock;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadC extends Thread {
    private Service service;

    public ThreadC(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.printC();
    }
}
