package chapter1.callMainMethodMainThread.suspend_resume.lockStop;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.suspend();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
