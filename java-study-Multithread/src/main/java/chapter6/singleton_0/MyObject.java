package chapter6.singleton_0;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class MyObject {
    private static MyObject myObject = new MyObject();
    private MyObject() {}
    public static MyObject getInstance() {
//        此代码版本为立即加载
//        此版本代码的缺点是不能有其他实例变量
//        因为 getinstance()方法没有同步
//        所以有可能出现非线程安全问题
        return myObject;
    }
}
