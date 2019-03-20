package chapter2.synchronizedMethodLockObject;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadA extends Thread {
    private MyObject object;

    public ThreadA(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.methodA();
    }
}
