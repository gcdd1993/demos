package chapter4.conditionTestManyToMany;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 通过使用 Condition对象,成功实现交替打印的效果
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
        ThreadB b = new ThreadB(service);
        b.start();
    }
}
