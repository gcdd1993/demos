package chapter3.join_sleep_2.join_sleep_1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 *
 * 由于线程ThreadA使用Thread.sleep
 (long)方法一直持有ThreadB对象的锁,时
 间达到6秒,所以线程ThreadC只有在ThreadA时间到达6秒后释放ThreadB的锁时,
 才可以调用ThreadB中的同步方法synchronized public void bService().
 */
public class Run {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
