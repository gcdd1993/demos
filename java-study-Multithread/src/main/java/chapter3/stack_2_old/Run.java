package chapter3.stack_2_old;

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
        P p = new P(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);
        C c5 = new C(myStack);
        PThread pThread = new PThread(p);
        CThread cThread1 = new CThread(c1);
        CThread cThread2 = new CThread(c2);
        CThread cThread3 = new CThread(c3);
        CThread cThread4 = new CThread(c4);
        CThread cThread5 = new CThread(c5);
        pThread.start();
        cThread1.start();
        cThread2.start();
        cThread3.start();
        cThread4.start();
        cThread5.start();
    }
}
