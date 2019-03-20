package chapter4.z3_ok;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 在控制台中只打印一个字母A，原因是调用了Condition对象的await）方法，使当前执
 行任务的线程进入了等待WAITING状态。
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
    }
}
