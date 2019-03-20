package chapter4.conditionTest;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadA extends Thread {
    private MyService service;

    @Override
    public void run() {
        for(int i=0;i<Integer.MAX_VALUE;i++) {
            service.set();
        }
    }
}
