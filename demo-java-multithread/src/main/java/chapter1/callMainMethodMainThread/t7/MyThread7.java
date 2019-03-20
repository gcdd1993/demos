package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/7.
 */
public class MyThread7 extends Thread {
    @Override
    public void run() {
        try {
            this.stop();
        }catch (ThreadDeath e) {
            System.out.println("进入了catch方法");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread7 thread7 = new MyThread7();
        thread7.start();
    }
}
