package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/7.
 * 1.7.2判断线程是否是停止状态
 *
 * 在介绍如何停止线程的知识点前，先来看一下如何判断线程的状态是不是停止的。在
 * Java的SDK中，Thread.java类里提供了两种方法。
 * 1）this.interrupted()：测试当前线程是否已经中断。
 * 2）this.isInterrupted()：测试线程是否已经中断。
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i = 0;i < 500000;i++) {
            System.out.println("i = " + (i + 1));
        }
    }

    /**
     * 测试当前线程是否已经中断，当前线程是指运行this.interrupted)方法的线程。
     */
//    public static void main(String[] args) {
//        try {
//            MyThread2 thread2 = new MyThread2();
//            thread2.start();
//            Thread.sleep(1000);
//            thread2.interrupted();
//            System.out.println("是否停止1 ? =" + thread2.isInterrupted());
//            System.out.println("是否停止2 ? =" + thread2.isInterrupted());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end!");
//    }

    /**
     * 测试当前线程是否已经中断。线程的中断状态由该方法清除。换句话说，如果连续两次
     * 调用该方法，则第二次调用将返回false（在第一次调用已清除了其中断状态之后，且第二次
     * 调用检验完中断状态前，当前线程再次中断的情况除外）。
     * @param args
     */
//    public static void main(String[] args) {
//        Thread.currentThread().interrupt();
//        System.out.println("是否停止1 ? =" + Thread.interrupted());
//        System.out.println("是否停止2 ? =" + Thread.interrupted());
//        System.out.println("end!");
//    }

    /**
     * 1）this.interupted():测试当前线程是否已经是中断状态，
     * 执行后具有将状态标志置清除为false的功能。
     * 2）this.isInterrupted():测试线程Thread对象是否已经
     * 是中断状态，但不清除状态标志。
     */
    public static void main(String[] args) {
        try {
            MyThread2 thread2 = new MyThread2();
            thread2.start();
            Thread.sleep(1000);
            thread2.interrupt();
            System.out.println("是否停止1 ? =" + thread2.isInterrupted());
            System.out.println("是否停止2 ? =" + thread2.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
