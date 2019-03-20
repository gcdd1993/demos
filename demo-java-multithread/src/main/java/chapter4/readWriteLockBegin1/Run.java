package chapter4.readWriteLockBegin1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 *4.2.1类ReentrantReadWriteLock的使用：读读共享
 * 从控制台中打印的时间来看，两个线程几乎同时进入lock0方法后面的代码。说明在此使用
 了lock.readLockO读锁可以提高程序运行效率，允许多个线程同时执行lock0方法后面的代码。
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");

        ThreadB b = new ThreadB(service);
        b.setName("B");

        a.start();
        b.start();
    }
}
