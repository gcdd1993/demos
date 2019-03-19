package chapter3.joinException;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class ThreadB extends Thread{
    @Override
    public void run() {
        try {
            ThreadA a = new ThreadA();
            a.start();
            a.join();
            System.out.println("线程B在run end 处打印了");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程B在catch 处打印了");
        }
    }
}
