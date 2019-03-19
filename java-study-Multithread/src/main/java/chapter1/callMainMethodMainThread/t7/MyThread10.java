package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread10 extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }

    public static void main(String[] args) {
        try {
            MyThread10 thread10 = new MyThread10();
            thread10.start();
            Thread.sleep(5000);
            //A
            thread10.suspend();
            System.out.println("A = " + System.currentTimeMillis() + "i= " + thread10.getI());
            Thread.sleep(5000);
            System.out.println("A = " + System.currentTimeMillis() + "i= " + thread10.getI());
            //B
            thread10.resume();
            Thread.sleep(5000);
            thread10.suspend();
            System.out.println("B = " + System.currentTimeMillis() + "i= " + thread10.getI());
            Thread.sleep(5000);
            System.out.println("B = " + System.currentTimeMillis() + "i= " + thread10.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
