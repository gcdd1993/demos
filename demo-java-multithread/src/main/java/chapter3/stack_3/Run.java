package chapter3.stack_3;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * one producer -> more consumer
 * 此问题的出现就是因为在MyStack.java类中使用了if语句作为条件判断
 * 因为条件发生改变时并没有得到及时的响应,所以多个呈wait状态的线程被唤醒,继而
 执行list.remove(0)代码而出现异常。解决这个办法是,将if改成while语句即可。
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        P p5 = new P(myStack);
        P p6 = new P(myStack);
        C c1 = new C(myStack);
        PThread pThread1 = new PThread(p1);
        PThread pThread2 = new PThread(p2);
        PThread pThread3 = new PThread(p3);
        PThread pThread4 = new PThread(p4);
        PThread pThread5 = new PThread(p5);
        PThread pThread6 = new PThread(p6);
        CThread cThread1 = new CThread(c1);
        pThread1.start();
        pThread2.start();
        pThread3.start();
        pThread4.start();
        pThread5.start();
        pThread6.start();
        cThread1.start();
    }
}
