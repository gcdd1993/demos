package chapter2.t3;

/**
 * Created by gaochen on 2018/8/8.
 */
public class PublicVar {
    private String username = "A";
    private String password = "AA";
    synchronized public void setValue(String username,String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("set value method thread name = " + Thread.currentThread().getName() + "username = " + this.username + " password" + this.password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void getValue() {
        System.out.println("get value method name = " + Thread.currentThread().getName() + " username = " + this.username + " password =" + this.password);
    }
}
