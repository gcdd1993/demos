package chapter1.callMainMethodMainThread.t1;

/**
 * Created by gaochen on 2018/8/7.
 * 继承 thread
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
    }
}
