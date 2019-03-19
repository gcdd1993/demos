package chapter6.singleton_2_1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject() {}
    //设置同步方法效率太低了,整个方法被上锁
    synchronized public static MyObject getInstance() {
        try {
            if(myObject == null) {
                    Thread.sleep(3000);
                myObject = new MyObject();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
