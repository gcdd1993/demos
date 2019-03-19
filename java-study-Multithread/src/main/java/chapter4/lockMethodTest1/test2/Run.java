package chapter4.lockMethodTest1.test2;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 2）方法int getQueueLength0的作用是返回正等
 待获取此锁定的线程估计数，比如有5个线程，1个线程首先执行await）方法，那么在调用
 getQueueLength)方法后返回值是4，说明有4个线程同时在等待lock的释放。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod1();
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
        System.out.println("有线程数:" + service.lock.getQueueLength() + "在等待获取锁");
    }
}
