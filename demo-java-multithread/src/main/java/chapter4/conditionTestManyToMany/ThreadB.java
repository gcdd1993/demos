package chapter4.conditionTestManyToMany;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadB extends Thread {
    private MyService service;

    @Override
    public void run() {
        for(int i=0;i<Integer.MAX_VALUE;i++) {
            service.get();
        }
    }
}
