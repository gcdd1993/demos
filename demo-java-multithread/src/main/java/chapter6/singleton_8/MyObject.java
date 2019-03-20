package chapter6.singleton_8;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 *使用静态内置类实现单例模式
 */
public class MyObject {
    private static MyObject instance = null;
    private MyObject() {}
    static {
        instance = new MyObject();
    }
    public static MyObject getInstance() {
        return instance;
    }
}
