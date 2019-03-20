package chapter2.synLockIn_2;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Sub extends Main {
    synchronized public void operateISubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i = " + i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
