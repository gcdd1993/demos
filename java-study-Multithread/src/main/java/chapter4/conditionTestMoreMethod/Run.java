package chapter4.conditionTestMoreMethod;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 *
 * 此实验说明，调用lock.lock()代码的线程就持有了“对象监视器”，其他线程只有等待
 锁被释放时再次争抢。效果和使用synchronized关键字一样，线程之间还是顺序执行的。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadAA aa = new ThreadAA(service);
        aa.setName("AA");
        aa.start();
        Thread.sleep(100);
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        ThreadBB bb = new ThreadBB(service);
        bb.setName("BB");
        bb.start();
    }
}
