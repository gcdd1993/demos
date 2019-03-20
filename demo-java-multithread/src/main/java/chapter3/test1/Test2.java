package chapter3.test1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 * 但线程不能永远等待下去,那样程序就停止不前,不继续向下运行了。
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            String lock = new String();
            System.out.println("syn 上面");
            synchronized (lock) {
                System.out.println("syn 第一行");
                lock.wait();
                System.out.println("wait 下面的代码");
            }
            System.out.println("syn 下面的代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
