package chapter2.t1;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(numRef);
        a.start();
        ThreadB b = new ThreadB(numRef);
        b.start();
    }
}
