package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/7.
 * 本示例将调用interrupt）方法来停止线程，但interrupt）方法的使用效果并不像
 * for+break语句那样，马上就停止循环。调用interrupt)方法仅仅是在当前线程中打了一个停
 * 止的标记，并不是真的停止线程。
 *
 * 从运行的结果来看，调用interrupt方法并没有停止线程。
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i = 0;i < 500000;i++) {
            System.out.println("i = " + (i + 1));
        }
    }

    public static void main(String[] args) {
        try {
            MyThread1 thread = new MyThread1();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
