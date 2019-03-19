package chapter3.inheritableThreadLocal;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++) {
                System.out.println("在ThreadA 线程中取值 = " + Tools.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
