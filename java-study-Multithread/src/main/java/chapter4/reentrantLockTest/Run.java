package chapter4.reentrantLockTest;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 *
 * 从运行的结果来看，当前线程打印完毕之后将锁进行释放，其他
 线程才可以继续打印。线程打印的数据是分组打印，因为当前线程已
 经持有锁，但线程之间打印的顺序是随机的。
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread t1 = new MyThread(service);
        MyThread t2 = new MyThread(service);
        MyThread t3 = new MyThread(service);
        MyThread t4 = new MyThread(service);
        MyThread t5 = new MyThread(service);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
