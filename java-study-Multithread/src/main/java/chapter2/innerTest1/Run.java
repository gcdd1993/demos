package chapter2.innerTest1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 *
 * 由于持有不同的“对象监视器”,所以打印结果就是乱序的。
 */
public class Run {
    public static void main(String[] args) {
        final OutClass.Inner inner = new OutClass.Inner();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method1();
            }
        },"A");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        },"B");
        t1.start();
        t2.start();
    }
}
