package chapter2.synchronizedMethodLockObject;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Run {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("a");
        ThreadB b = new ThreadB(object);
        b.setName("b");
        a.start();
        b.start();
    }
}
