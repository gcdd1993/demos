package chapter1.callMainMethodMainThread.t3;

/**
 * Created by gaochen on 2018/8/7.
 * 共享数据的情况就是多个线程可以访问同一个变量,比如在实现投票功能的软件时,多
 * 个线程可以同时处理同一个人的票数。
 *
 * 线程A和B打印出的 count值都是3,说明A和B同时对 count进行处理,产生了“非线程安全”问
 * 题。而我们想要得到的打印结果却不是重复的,而是依次递减的。
 * 在某些JVM中,i--的操作要分成如下3步
 * 1)取得原有i值
 * 2)计算i-1。
 * 3)对i进行赋值。
 * 在这3个步骤中,如果有多个线程同时访问,那么一定会出现非线程安全问题。
 *
 * 本节中出现了一个术语“非线程安全”。非线程安全主要是指多个线程对同一个对象中
 * 的同一个实例变量进行操作时会出现值被更改、值不同步的情况，进而影响程序的执行流
 * 程。下面再用一个示例来学习一下如何解决“非线程安全”问题。
 */
public class MyThread2 extends Thread {
    private int count = 5;

    /**
     * 通过在run方法前加入synchronized关键字，使多个线程在执
     * 行run方法时，以排队的方式进行处理。当一个线程调用run前，
     * 先判断run方法有没有被上锁，如果上锁，说明有其他线程正在
     * 调用run方法，必须等其他线程对run方法调用结束后才可以执行
     * run方法。这样也就实现了排队调用run方法的目的，也就达到了
     * 按顺序对count变量减1的效果了。synchronized可以在任意对象
     * 及方法上加锁，而加锁的这段代码称为“互斥区”或“临界区”。
     *
     * 当一个线程想要执行同步方法里面的代码时，线程首先尝试
     * 去拿这把锁，如果能够拿到这把锁，那么这个线程就可以执行synchronize里面的代码。如
     * 果不能拿到这把锁，那么这个线程就会不断地尝试拿这把锁，直到能够拿到为止，而且是
     * 有多个线程同时去争抢这把锁。
     */
    @Override
    synchronized public void run() {
        super.run();
        count --;
//      此示例不要用for语句,因为使用同步后其他线程就得不到运行的机会了,
//      一直由一个线程进行减法运算
        System.out.println("由 " + currentThread().getName() + "计算,count = " + count);
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread a = new Thread(myThread2,"a");
        Thread b = new Thread(myThread2,"b");
        Thread c = new Thread(myThread2,"c");
        Thread d = new Thread(myThread2,"d");
        Thread e = new Thread(myThread2,"e");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }

}
