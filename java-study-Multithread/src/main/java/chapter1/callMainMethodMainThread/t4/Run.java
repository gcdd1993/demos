package chapter1.callMainMethodMainThread.t4;

/**
 * Created by gaochen on 2018/8/7.
 */
public class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
