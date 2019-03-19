package chapter2.synTwoLock;

/**
 * Created by gaochen on 2018/8/8.
 * 异步的原因是持有不同的锁,一个是对象锁,
 * 另外一个是Class锁,而 Class锁可以对类的所有对
 * 象实例起作用。
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
        ThreadC c = new ThreadC(service);
        c.setName("c");
        c.start();
    }
}
