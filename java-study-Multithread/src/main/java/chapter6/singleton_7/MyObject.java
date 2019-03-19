package chapter6.singleton_7;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 *使用静态内置类实现单例模式
 */
public class MyObject {
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }
    private MyObject() {}
    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }
}
