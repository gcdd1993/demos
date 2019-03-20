package chapter4.readWriteLockBegin3;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 4.2.3类ReentrantReadWriteLock的使用：读写互斥
 即只要出现“写操作”的过程，就是互斥的。
 从控制台中打印的结果来看，“写读”操作也是互斥的。
 “读写”、“写读”和“写写”都是互斥的；而“读读”是异步的，非互斥的。
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
