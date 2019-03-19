package chapter3.stack_4;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class PThread extends Thread {
    private P p;

    @Override
    public void run() {
        while (true) {
            p.pushService();
        }
    }
}
