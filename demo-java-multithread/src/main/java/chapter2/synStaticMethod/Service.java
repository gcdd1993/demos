package chapter2.synStaticMethod;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Service {
    synchronized public static void printA() {
        try {
            System.out.println("线程名称为 : " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为 : " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public static void printB() {
        System.out.println("线程名称为 : " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为 : " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "离开printB");
    }
}
