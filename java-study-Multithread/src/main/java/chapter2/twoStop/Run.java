package chapter2.twoStop;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();
        ThreadB b = new ThreadB(service);
        b.start();
    }
}
