package chapter2.synBlockString;

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
        service.setUsernamePassword("b","bb");
    }
}
