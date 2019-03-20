package chapter1.callMainMethodMainThread.yield;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for(int i=0;i<50000000;i++) {
            //Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时 : " + (endTime - beginTime) + "毫秒");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
