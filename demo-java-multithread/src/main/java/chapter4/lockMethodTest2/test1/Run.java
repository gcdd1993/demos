package chapter4.lockMethodTest2.test1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 *
 * 1）方法boolean hasQueued Thread(Thread thread)的作用是查询指定的线程是否正在等待
 获取此锁定。
 方法boolean hasQueuedThreads)的作用是查询是否有线程正在等待获取此锁定。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };
        Thread a = new Thread(runnable);
        a.start();
        Thread.sleep(500);
        Thread b = new Thread(runnable);
        b.start();
        Thread.sleep(500);

        System.out.println(service.lock.hasQueuedThread(a));
        System.out.println(service.lock.hasQueuedThread(b));
        System.out.println(service.lock.hasQueuedThreads());
    }
}
