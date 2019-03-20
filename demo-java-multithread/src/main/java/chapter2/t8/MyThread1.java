package chapter2.t8;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread1 extends Thread {
    private Task task;

    public MyThread1(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
