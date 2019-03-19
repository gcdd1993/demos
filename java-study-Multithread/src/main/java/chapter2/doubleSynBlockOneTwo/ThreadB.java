package chapter2.doubleSynBlockOneTwo;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadB extends Thread {
    private ObjectService service;

    public ThreadB(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethodB();
    }
}
