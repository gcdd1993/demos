package chapter2.t99;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 *
 *   停不下来的原因主要就是main线程
     直在处理 whilel循环,导致程序不能
     继续执行后面的代码。解决的办法当然
     是用多线程技术。
 */
public class Run {
    public static void main(String[] args) {
        PrintString printStringService = new PrintString();
        printStringService.printStringMethod();
        System.out.println("我要停止它 stopThread = " + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }
}
