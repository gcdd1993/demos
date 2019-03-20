package chapter2.synMoreObjectStaticOneLock;

/**
 * Created by gaochen on 2018/8/8.
 * 同步 synchronized(class)代码块的作用其实和
 * synchronized static方法的作用一样。
 */
public class Run {
    public static void main(String[] args) {
        Service service1 = new Service();
        Service service2 = new Service();
        ThreadA a = new ThreadA(service1);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(service2);
        b.setName("b");
        b.start();
    }
}
