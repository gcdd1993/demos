package chapter3.p_c_allWait_fix;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 *
 * 在代码中确实已经通过wait/notify进行通信了,但不保证notify唤醒的是异类,也许是
 同类,比如\u201c生产者\u201d唤醒\u201c生产者\u201d,或\u201c消费者\u201d唤醒\u201c消费者\u201d这样的情况。如果按
 这样情况运行的比率积少成多,就会导致所有的线程都不能继续运行下去,大家都在等待,
 都呈WAITING状态,程序最后也就呈\u201c假死\u201d状态,不能继续运行下去了。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);
        ThreadP[] pThread = new ThreadP[2];
        ThreadC[] cThread = new ThreadC[2];
        for(int i=0;i<2;i++) {
            pThread[i] = new ThreadP(p);
            pThread[i].setName("producer " + (i + 1));
            cThread[i] = new ThreadC(r);
            cThread[i].setName("consumer " + (i + 1));
            pThread[i].start();
            cThread[i].start();
        }
        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for(int i=0;i< threads.length;i++) {
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }
    }
}
