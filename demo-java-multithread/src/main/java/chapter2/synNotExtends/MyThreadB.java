package chapter2.synNotExtends;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThreadB extends Thread {
    private Sub sub;

    public MyThreadB(Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
