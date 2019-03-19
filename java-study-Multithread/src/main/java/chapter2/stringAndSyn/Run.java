package chapter2.stringAndSyn;

/**
 * Created by gaochen on 2018/8/8.
 * 出现这样的情况就是因为 String的两个值都是AA,两个线程持有相同的锁,所以造
 * 成线程B不能执行。这就是 String常量池所带来的问题。因此在大多数的情况下,同步
 * synchronized代码块都不使用 String作为锁对象,而改用其他,比如 new Object()实例化一个
 * Object对象,但它并不放入缓存中。
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
