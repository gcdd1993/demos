package chapter6.singleton_2_2;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 * (2)尝试同步代码块
 同步方法是对方法的整体进行持锁,这对运行效率来讲是不利的。改成同步代码块能解决吗?


 */
public class MyObject {
    private static MyObject myObject;
    private MyObject() {}
    public static MyObject getInstance() {
        try {
            //∥此种写法等同于:
            ///synchronized public static Myobject getinstance()
            //∥的写法,效率一样很低,全部代码被上锁
            synchronized (MyObject.class) {
                if(myObject == null) {
                    Thread.sleep(3000);
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
