package chapter6.singleton_5;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 *
 * （4）使用DCL双检查锁机制
 在最后的步骤中，使用的是DCL双检查锁机制来实现多线程环境中的延迟加载单例设
 计模式。

 此版本的代码称为双重检查 Double- Check Locking

 使用双重检查锁功能,成功地解决了“懒汉模式”遇到多线程的问题。DCL也是大多数
 多线程结合单例模式使用的解决方案。
 */
public class MyObject {
    private volatile static MyObject myObject;
    private MyObject() {}
    public static MyObject getInstance() {
        try {
            if(myObject == null) {
                Thread.sleep(3000);
                //∥使用 synchronized( Myobject.class)
                //∥虽然部分代码被上锁
                //∥但还是有非线程安全问题
                synchronized (MyObject.class) {
                    if(myObject == null) {
                        myObject = new MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
