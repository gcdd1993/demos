package chapter4.useConditionWaitNotifyOK;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 成功实现等待/通知模式。
 Object类中的wait)方法相当于Condition类中的await)方法。
 Object 类中的waitlong timeout)方法相当于Condition类中的await(long time,TimeUnit unit)方法。
 Object类中的notify（）方法相当于Condition类中的signal0方法。
 Object类中的notifyAll0方法相当于Condition类中的signalAll0方法。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(3000);
        service.signal();
    }
}
