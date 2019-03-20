package chapter2.t3;

/**
 * Created by gaochen on 2018/8/8.
 */
public class ThreadA extends Thread {
    private PublicVar publicVar;

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }

    public ThreadA(PublicVar publicVar) {
        this.publicVar = publicVar;
    }
}
