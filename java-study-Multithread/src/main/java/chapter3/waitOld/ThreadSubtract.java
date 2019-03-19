package chapter3.waitOld;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class ThreadSubtract extends Thread {
    private Subtract r;

    public ThreadSubtract(Subtract r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}
