package chapter2.synchronizedOneThreadIn;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadA extends Thread {
    private ObjectService service;

    public ThreadA(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethod();
    }
}
