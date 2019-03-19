package chapter3.notifyHoldLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 * 此实验说明,必须执行完notify()
 方法所在的同步synchronized代码块后
 才释放锁。
 */
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();
    }
}
