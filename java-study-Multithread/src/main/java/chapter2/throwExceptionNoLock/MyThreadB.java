package chapter2.throwExceptionNoLock;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThreadB extends Thread {
    private Service service;

    public MyThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
