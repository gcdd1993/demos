package chapter3.join_sleep_1;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadC extends Thread {
    private ThreadB threadB;
    @Override
    public void run() {
        threadB.bService();
    }

}
