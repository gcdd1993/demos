package chapter2.t1;

/**
 * Created by gaochen on 2018/8/8.
 */
public class HasSelfPrivateNum {
    public void addI(String username) {
        try {
            int num = 0;
            if(username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + "num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
