package chapter6.singleton_1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 *控制台打印出了3种 hash Code,说明创建出了3个对象,并不是单例的,这就是“错误
 的单例模式”。如何解决呢?先看一下解决方案。
 */
public class Run {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
