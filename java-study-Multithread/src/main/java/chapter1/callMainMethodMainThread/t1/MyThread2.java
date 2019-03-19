package chapter1.callMainMethodMainThread.t1;

/**
 * Created by gaochen on 2018/8/7.
 * 另外还需要注意一下,执行star(方法的顺序不代表线程启动的顺序。
 */
public class MyThread2 extends Thread {
    private int i;
    public MyThread2(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        MyThread2 th1 = new MyThread2(1);
        MyThread2 th2 = new MyThread2(2);
        MyThread2 th3 = new MyThread2(3);
        MyThread2 th4 = new MyThread2(4);
        MyThread2 th5 = new MyThread2(5);
        MyThread2 th6 = new MyThread2(6);
        MyThread2 th7 = new MyThread2(7);
        MyThread2 th8 = new MyThread2(8);
        MyThread2 th9 = new MyThread2(9);
        MyThread2 th10 = new MyThread2(10);
        MyThread2 th11 = new MyThread2(11);
        MyThread2 th12 = new MyThread2(12);
        MyThread2 th13 = new MyThread2(13);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th8.start();
        th9.start();
        th10.start();
        th11.start();
        th12.start();
        th13.start();
    }
}
