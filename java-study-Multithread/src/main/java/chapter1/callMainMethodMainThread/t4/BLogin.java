package chapter1.callMainMethodMainThread.t4;

/**
 * Created by gaochen on 2018/8/7.
 */
public class BLogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}
