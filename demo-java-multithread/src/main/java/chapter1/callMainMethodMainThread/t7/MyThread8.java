package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/7.
 */
public class MyThread8 extends Thread {
    private SynchronizedObject object;

    public MyThread8(SynchronizedObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b","bb");
    }

    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread8 thread8 = new MyThread8(object);
            thread8.start();
            Thread.sleep(500);
            thread8.stop();
            System.out.println(object.getUsername() + " " + object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
