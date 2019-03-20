package chapter1.callMainMethodMainThread.suspend_resume.dealLock;

/**
 * Created by gaochen on 2018/8/8.
 */
public class SynchronizedObject {
    synchronized public void printString() {
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")) {
            System.out.println("a 线程永远suspend了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");    }

    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread() {

                @Override
                public void run() {
                    object.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2 启动了，但进入不了printString() 方法，只打印一个begin");
                    System.out.println("因为printString() 方法被a线程锁定并且永远suspend暂停了");
                    object.printString();
                }
            };
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
