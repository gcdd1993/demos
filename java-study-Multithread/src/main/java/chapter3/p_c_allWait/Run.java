package chapter3.p_c_allWait;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 *
 创建pc allWait fix项目,将p c allWait项目中的所有源代码复制到pc allWait fix项
 目中。解决\u201c假死\u201d的情况很简单,将Pjava和C.java文件中的notify()改成notifyAl()方
 法即可,它的原理就是不光通知同类线程,也包括异类。这样就不至于出现假死的状态了.
 程序会一直运行下去。
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
