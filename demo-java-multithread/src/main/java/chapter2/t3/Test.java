package chapter2.t3;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Test {
    public static void main(String[] args) {
        try {
            PublicVar publicVarRef = new PublicVar();
            ThreadA threadA = new ThreadA(publicVarRef);
            threadA.start();
            Thread.sleep(200);
            publicVarRef.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
