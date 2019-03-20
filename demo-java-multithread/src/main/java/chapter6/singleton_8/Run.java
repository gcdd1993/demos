package chapter6.singleton_8;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 * 6.5使用 static代码块实现单例模式
 静态代码块中的代码在使用类的时候就已经执行了,所以可以应用静态代码块的这个特
 性来实现单例设计模式。
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
