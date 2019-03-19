package chapter2.t9;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread1 extends Thread {
    private MyOneList list;

    public MyThread1(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list,"A");
    }
}
