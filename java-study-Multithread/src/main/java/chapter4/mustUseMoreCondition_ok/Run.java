package chapter4.mustUseMoreCondition_ok;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 4.1.5使用多个 Condition实现通知部分线程:错误用法
 * 如果想单独唤醒部分线程该怎么处理呢？这时就有必要使用多个Condition对象了，也
 就是Condition对象可以唤醒部分指定线程，有助于提升程序运行的效率。可以先对线程进
 行分组，然后再唤醒指定组中的线程。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        service.signalAllA();
    }
}
