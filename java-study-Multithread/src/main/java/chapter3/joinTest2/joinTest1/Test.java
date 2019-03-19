package chapter3.joinTest2.joinTest1;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 方法join的作用是使所属的线程对
 象x正常执行run()方法中的任务,而使
 当前线程z进行无限期的阻塞,等待线程 销毁后再继续执行线程z后面的代码。
 方法join具有使线程排队运行的作用,有些类似同步的运行效果。join与synchronized
 的区别是: join在内部使用wait()方法进行等待,而sychronized关键字使用的是\u201c对象监视
 器\u201d原理做为同步。
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println("我想当threadTest对象执行完毕后我再执行,我做到了");
    }
}
