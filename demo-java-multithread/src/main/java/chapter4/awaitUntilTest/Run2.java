package chapter4.awaitUntilTest;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 * 说明线程在等待时间到达前,可以被其他线程提
 前唤醒。
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(2000);
        ThreadB b = new ThreadB(service);
        b.start();
    }
}
