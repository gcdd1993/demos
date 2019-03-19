package chapter4.tryLock;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 方法 void lockinterruptiblyo的作用是:如果当前线程未被中断,则获取锁定,如果已经被中断则出现异常
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 调用waitMethod 时间 : " + System.currentTimeMillis());
                service.waitMethod();
            }
        };
        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
    }
}
