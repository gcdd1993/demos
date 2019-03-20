package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/7.
 * 1.7.5能停止的线程——暴力停止
 * 使用stop方法停止线程则是非常暴力的。
 */
public class MyThread6 extends Thread {
    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread6 thread6 = new MyThread6();
            thread6.start();
            Thread.sleep(8000);
            thread6.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
