package chapter4.awaitUntilTest;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();
    }
}
