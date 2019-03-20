package chapter1.callMainMethodMainThread.t3;

/**
 * Created by gaochen on 2018/8/7.
 * 自定义线程类中的实例变量针对其他线程可以有共享与不共享之分,这在多个线程之间
 * 进行交互时是很重要的一个技术点。
 *
 * 下面通过一个示例来看下数据不共享情况。
 */
public class MyThread1 extends Thread {
    private int count = 5;

    public MyThread1(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count --;
            System.out.println("由 " + currentThread().getName() + "计算,count = " + count);
        }
    }

    public static void main(String[] args) {
        MyThread1 a = new MyThread1("a");
        MyThread1 b = new MyThread1("b");
        MyThread1 c = new MyThread1("c");
        a.start();
        b.start();
        c.start();
    }
}
