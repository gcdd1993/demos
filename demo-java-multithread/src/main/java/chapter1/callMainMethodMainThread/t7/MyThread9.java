package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread9 extends Thread {
    @Override
    public void run() {
        while (true) {
            if(this.isInterrupted()) {
                System.out.println("停止了");
                return;
            }
            System.out.println("timer : " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread9 thread9 = new MyThread9();
        thread9.start();
        Thread.sleep(2000);
        thread9.interrupt();
    }
}
