package chapter6.singleton_1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject() {}
    public static MyObject getInstance() {
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
