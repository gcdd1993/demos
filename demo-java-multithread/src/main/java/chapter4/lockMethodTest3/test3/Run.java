package chapter4.lockMethodTest3.test3;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 方法 boolean isheld By Currentthreado的作用是查询当前线程是否保持此锁定
 */
public class Run {
    public static void main(String[] args) {
        final Service service1 = new Service(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service1.serviceMethod();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
