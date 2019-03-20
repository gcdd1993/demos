package chapter4.awaitUninterruptiblyTest1;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class MyThread extends Thread {
    private MyService myService;

    @Override
    public void run() {
        myService.testMethod();
    }
}
