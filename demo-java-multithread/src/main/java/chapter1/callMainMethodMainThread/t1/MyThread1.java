package chapter1.callMainMethodMainThread.t1;

/**
 * Created by gaochen on 2018/8/7.
 * 线程的随机性
 *
 * Thread.java类中的start方法通知“线程规划器”此线程已经准备
 * 就绪，等待调用线程对象的runO方法。这个过程其实就是让系统安排
 * 一个时间来调用Thread中的run0方法，也就是使线程得到运行，启动
 * 线程，具有异步执行的效果。
 * 如果调用代码thread.run就不是异步执行了，而是同步，那么此线程对象并不交给“线程规划器”来进行处理，
 * 而是由main主线程来调用run)方法，也就是必须等runO方法中的代
 * 码执行完后才可以执行后面的代码。
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread1 myThread1 = new MyThread1();
            myThread1.setName("myThread1");
            myThread1.start();
            for(int i=0;i<10;i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
