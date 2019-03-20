package chapter3.joinException;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadC extends Thread {
    private ThreadB b;

    @Override
    public void run() {
        b.interrupt();
    }
}
