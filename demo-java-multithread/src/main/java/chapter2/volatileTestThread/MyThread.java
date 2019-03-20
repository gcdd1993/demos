package chapter2.volatileTestThread;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class MyThread extends Thread {
    volatile public static int count;

    /**
     * 注意一定要添加 static关键字
     * 这样 synchronized与 static锁的内容就是 Mythread. class类了
     * 也就达到同步的效果了
     */
    synchronized private static void addCount() {
        for(int i = 0;i<100;i++) {
            count ++;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
