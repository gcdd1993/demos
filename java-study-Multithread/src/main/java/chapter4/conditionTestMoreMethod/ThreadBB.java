package chapter4.conditionTestMoreMethod;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadBB extends Thread {
    private MyService service;

    @Override
    public void run() {
        service.methodB();
    }
}
