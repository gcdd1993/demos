package chapter2.stringAndSyn;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Service {
    public static void print(String stringParam) {
        try {
            synchronized (stringParam) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
