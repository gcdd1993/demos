package base;

/**
 * @author gaochen
 * @date 2019/3/11
 */
public class SimpleBean {
    public void send() {
        System.out.println("Hello Spring Bean!");
    }

    public static class InnerBean {
        public void innerSend() {
            System.out.println("hello inner bean !");
        }
    }
}
