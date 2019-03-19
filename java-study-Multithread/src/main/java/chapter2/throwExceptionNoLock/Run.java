package chapter2.throwExceptionNoLock;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Run {
    public static void main(String[] args) {
        try {
            Service service = new Service();
            MyThreadA a = new MyThreadA(service);
            a.setName("a");
            a.start();
            Thread.sleep(500);
            MyThreadB b = new MyThreadB(service);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
