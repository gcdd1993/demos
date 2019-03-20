package chapter3.joinException;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        for(int i=0;i<Integer.MAX_VALUE;i++) {
            String newString = new String();
            Math.random();
        }
    }
}
