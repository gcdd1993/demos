package chapter4.awaitUntilTest;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
@AllArgsConstructor
public class ThreadB extends Thread {
    private Service service;

    @Override
    public void run() {
        service.notifyMethod();
    }
}
