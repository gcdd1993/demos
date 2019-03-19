package chapter4.lockMethodTest2.test2;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 方法boolean hasWaiters（Condition condition)的作用是
 查询是否有线程正在等待与此锁定有关的condition条件。
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
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i=0;i<10;i++) {
            threads[i].start();
        }
        Thread.sleep(2000);
        service.notifyMethod();
    }
}
