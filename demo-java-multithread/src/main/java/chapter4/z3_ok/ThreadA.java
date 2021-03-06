package chapter4.z3_ok;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadA extends Thread {
    private MyService myService;

    @Override
    public void run() {
        myService.await();
    }
}
