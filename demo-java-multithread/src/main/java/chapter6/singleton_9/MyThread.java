package chapter6.singleton_9;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println(MyObject.connectionFactory.getConnection().hashCode());
        }
    }
}
