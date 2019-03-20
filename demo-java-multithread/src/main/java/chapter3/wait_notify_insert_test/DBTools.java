package chapter3.wait_notify_insert_test;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class DBTools {
    volatile private boolean preIsA = false;
    synchronized public void backupA() {
        try {
            while (preIsA) {
                wait();
            }
            for(int i=0;i<5;i++) {
                System.out.println(" ★ ★ ★ ★ ★ ");
            }
            preIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void backupB() {
        try {
            while (!preIsA) {
                wait();
            }
            for(int i=0;i<5;i++) {
                System.out.println(" ☆ ☆ ☆ ☆ ☆ ");
            }
            preIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
