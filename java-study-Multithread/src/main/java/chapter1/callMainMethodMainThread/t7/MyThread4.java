package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/7.
 * 1.7.4在沉睡中停止
 */
public class MyThread4 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止!进入catch！" + this.isInterrupted());
            e.printStackTrace();
        }
    }

    /**
     * 从打印的结果来看，如果在sleep状态下
     * 停止某一线程，会进入catch语句，并且清除
     * 停止状态值，使之变成false。
     * 前一个实验是先sleep然后再用interrupt0
     * 停止，与之相反的操作在学习线程时也要注意。{@link MyThread5}
     */
    public static void main(String[] args) {
        try {
            MyThread4 thread = new MyThread4();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
