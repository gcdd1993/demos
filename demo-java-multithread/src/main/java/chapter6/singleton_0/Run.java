package chapter6.singleton_0;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 *
 * 6.1立即加载/“饿俄汉模式
 什么是立即加载?立即加载就是使用类的时候已经将对象创建完毕,常见的实现办法就
 是直接new实例化。而立即加载从中文的语境来看,有“着急”、“急迫”的含义,所以也称
 为“饿汉模式”。
 立即加载/“饿汉模式”是在调用方法前,实例已经被创建了,来看一下实现代码。

 * 控制台打印的 hash Code是同一个值,说明对象是同一个,也就实
 现了立即加载型单例设计模式。
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
