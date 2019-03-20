package chapter3.stack_1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * one producer -> one consumer
 * 通过使用生产者/消费者模式,容器size()的值不会大于1,这也是本示例想要实现的效
 果,值在0和1之间进行交替,也就是生产和消费这两个过程在交替执行。
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        PThread pThread = new PThread(p);
        CThread cThread = new CThread(c);
        pThread.start();
        cThread.start();
    }
}
