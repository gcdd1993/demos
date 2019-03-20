package chapter4.lockMethodTest3.test1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 方法 boolean isfairo的作用是判断是不是公平锁。
 * 在默认的情况下, Reentrantlock类使用的是非公平锁。
 */
public class Run {
    public static void main(String[] args) {
        final Service service1 = new Service(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service1.serviceMethod();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        final Service service2 = new Service(false);
        runnable = new Runnable() {
            @Override
            public void run() {
                service2.serviceMethod();
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }
}
