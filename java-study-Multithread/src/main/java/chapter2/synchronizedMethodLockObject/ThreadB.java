package chapter2.synchronizedMethodLockObject;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadB extends Thread {
    private MyObject object;

    public ThreadB(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.methodB();
    }
}
