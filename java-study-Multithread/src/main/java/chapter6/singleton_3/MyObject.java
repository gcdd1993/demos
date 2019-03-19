package chapter6.singleton_3;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 3)针对某些重要的代码进行单独的同步
 同步代码块可以针对某些重要的代码进行单独的同步,而其他的代码则不需要同步。这
 样在运行时,效率完全可以得到大幅提升。
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject() {}
    public static MyObject getInstance() {
        try {
            if(myObject == null) {
                Thread.sleep(3000);
                //∥使用 synchronized( Myobject.class)
                //∥虽然部分代码被上锁
                //∥但还是有非线程安全问题
                synchronized (MyObject.class) {
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
