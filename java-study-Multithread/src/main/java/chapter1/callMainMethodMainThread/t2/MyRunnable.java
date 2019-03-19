package chapter1.callMainMethodMainThread.t2;

/**
 * Created by gaochen on 2018/8/7.
 * 如果欲创建的线程类已经有一个父类了,这时就不能再继承自 Thread类了,因为Java
 * 不支持多继承,所以就需要实现 Runnable接口来应对这样的情况。
 *
 * 使用继承 Thread类的方式来开发多线程应用程序在设计上是有局限性的,因为Java是
 * 单根继承,不支持多继承,所以为了改变这种限制,可以使用实现 Runnable接口的方式来实
 * 现多线程技术。这也是上面的示例介绍的知识点。
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("运行中");
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束");
    }
}
