package chapter1.callMainMethodMainThread.t6;

/**
 * Created by gaochen on 2018/8/7.
 */
public class ThreadMethodExample extends Thread {

    @Override
    public void run() {
        System.out.println("run = " + this.isAlive());
    }

    public static void main(String[] args) {
        //current Thread方法可返回代码段正在被哪个线程调用的信息。
        System.out.println(Thread.currentThread().getName());

        //方法 salive的作用是测试线程是否处于活动状态。什么是活动状态呢?活动状态
        //就是线程已经启动且尚未终止。线程处于正在运行或准备开始运行的状态,就认为线程是
        //“存活”的。
        ThreadMethodExample th = new ThreadMethodExample();
        System.out.println("begin == " + th.isAlive());
        th.start();
        System.out.println("end == " + th.isAlive());

        //方法 sleep的作用是在指定的毫秒数内让当前“正在执行的线程”休眠(暂停执行)。
        //这个“正在执行的线程”是指 this. currentthread返回的线程。
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("id : " + Thread.currentThread().getId());
    }

}
