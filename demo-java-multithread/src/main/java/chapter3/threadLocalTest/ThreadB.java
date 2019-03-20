package chapter3.threadLocalTest;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for(int i=0;i<100;i++) {
                Tools.t1.set("ThreadB " + (i+1));
                System.out.println("ThreadB get value = " + Tools.t1.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
