package chapter2.synStaticMethod;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Run {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("b");
        b.start();
    }
}
