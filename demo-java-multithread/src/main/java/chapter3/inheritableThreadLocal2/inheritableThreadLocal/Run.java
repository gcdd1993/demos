package chapter3.inheritableThreadLocal2.inheritableThreadLocal;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 *
 * 但在使用InheritableThreadLocal类需要注意一点的是,如果子线程在取得值的同时,主
 线程将InheritableThreadLocal中的值进行更改,那么子线程取到的值还是旧值。
 */
public class Run {
    public static void main(String[] args) {
        try {
            for(int i=0;i<10;i++) {
                System.out.println("在main 线程中取值 = " + Tools.t1.get());
                Thread.sleep(100);
                Thread.sleep(5000);
                ThreadA a = new ThreadA();
                a.start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
