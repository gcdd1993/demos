package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/7.
 */
public class MyThread5 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i=0;i<100000;i++) {
                System.out.println("i=" + (i+1));
            }
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止,再遇到了sleep!进入catch!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread5 thread5 = new MyThread5();
        thread5.start();
        thread5.interrupt();
        System.out.println("end!");
    }
}
