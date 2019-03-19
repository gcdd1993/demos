package chapter3.p_c_allWait_fix;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
@AllArgsConstructor
public class ThreadP extends Thread {
    private P p;

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
