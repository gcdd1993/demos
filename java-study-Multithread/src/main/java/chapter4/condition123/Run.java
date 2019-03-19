package chapter4.condition123;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class Run {
    volatile private static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition CONDITION_A = lock.newCondition();
    final private static Condition CONDITION_B = lock.newCondition();
    final private static Condition CONDITION_C = lock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 1) {
                        CONDITION_A.await();
                    }
                    for(int i=0;i<3;i++) {
                        System.out.println("Thread a " + (i + 1));
                    }
                    nextPrintWho = 2;
                    CONDITION_B.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread b = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 2) {
                        CONDITION_B.await();
                    }
                    for(int i=0;i<3;i++) {
                        System.out.println("Thread b " + (i + 1));
                    }
                    nextPrintWho = 3;
                    CONDITION_C.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread c = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 3) {
                        CONDITION_C.await();
                    }
                    for(int i=0;i<3;i++) {
                        System.out.println("Thread c " + (i + 1));
                    }
                    nextPrintWho = 1;
                    CONDITION_A.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread[] aThreads = new Thread[5];
        Thread[] bThreads = new Thread[5];
        Thread[] cThreads = new Thread[5];

        for(int i=0;i<5;i++) {
            aThreads[i] = new Thread(a);
            bThreads[i] = new Thread(b);
            cThreads[i] = new Thread(c);
            aThreads[i].start();
            bThreads[i].start();
            cThreads[i].start();
        }
    }

}
