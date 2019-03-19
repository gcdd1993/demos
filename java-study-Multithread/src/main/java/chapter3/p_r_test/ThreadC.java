package chapter3.p_r_test;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
@AllArgsConstructor
public class ThreadC extends Thread {
    private C c;

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
