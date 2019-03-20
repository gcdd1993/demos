package chapter6.singleton_7_1;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 *使用静态内置类实现单例模式
 */
public class MyObject implements Serializable {
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }
    private MyObject() {}
    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }
    protected Object readResolve() {
        System.out.println("run readResolve ");
        return MyObjectHandler.myObject;
    }
}
