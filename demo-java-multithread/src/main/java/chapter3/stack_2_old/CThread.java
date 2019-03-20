package chapter3.stack_2_old;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class CThread extends Thread {
    private C c;

    @Override
    public void run() {
        while (true) {
            c.popService();
        }
    }
}
