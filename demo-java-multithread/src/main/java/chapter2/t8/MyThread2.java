package chapter2.t8;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThread2 extends Thread {
    private Task task;

    public MyThread2(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.otherMethod();
    }
}
