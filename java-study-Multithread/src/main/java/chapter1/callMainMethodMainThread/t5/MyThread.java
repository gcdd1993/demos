package chapter1.callMainMethodMainThread.t5;

/**
 * Created by gaochen on 2018/8/7.
 *
 * 在前面章节中，解决非线程安全问题使用的是synchronized关键字，本节将通过程序案
 * 例细化一下println0方法与i计+联合使用时“有可能”出现的另外一种异常情况，并说明其
 * 中的原因。
 */
public class MyThread extends Thread {
    private int i = 5;
    @Override
    public void run() {
        System.out.println("i = " + (i--) + "threadName=" + Thread.currentThread().getName());
    }

    //本实验的测试目的是：虽然println0方法在内部是同步的，但i--的操作却是在进入
    //printlnO之前发生的，所以有发生非线程安全问题的概率
    public static void main(String[] args) {
        MyThread run = new MyThread();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        Thread t5 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
