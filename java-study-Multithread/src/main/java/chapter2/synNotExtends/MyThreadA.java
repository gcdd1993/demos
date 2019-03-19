package chapter2.synNotExtends;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThreadA extends Thread {
    private Sub sub;

    @Override
    public void run() {
        sub.serviceMethod();
    }

    public MyThreadA(Sub sub) {
        this.sub = sub;
    }
}
