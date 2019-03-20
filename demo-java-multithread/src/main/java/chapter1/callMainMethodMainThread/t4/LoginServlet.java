package chapter1.callMainMethodMainThread.t4;

/**
 * Created by gaochen on 2018/8/7.
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username,String password) {
        try {
            usernameRef = username;
            if(username.equals("a")) {
                Thread.sleep(5000);
                passwordRef = password;
                System.out.println("username = " + usernameRef + " password = " + passwordRef);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
