package chapter2.stringAndSyn;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.print("AA");
    }
}
