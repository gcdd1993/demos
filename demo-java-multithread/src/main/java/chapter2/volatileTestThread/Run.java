package chapter2.volatileTestThread;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class Run {
    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[100];
        for(int i =0;i < 100;i++) {
            myThreads[i] = new MyThread();
        }
        for(int i = 0;i < 100;i++) {
            myThreads[i].start();
        }
    }
}
