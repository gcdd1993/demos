package chapter2.throwExceptionNoLock;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThreadA extends Thread {
    private Service service;

    public MyThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
