package chapter3.test1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 *
 * 出现异常的原因是没有"对象监视器",也就是没有同步加锁。
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
