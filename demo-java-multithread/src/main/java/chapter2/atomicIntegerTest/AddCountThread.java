package chapter2.atomicIntegerTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for(int i = 0;i < 10000;i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}
