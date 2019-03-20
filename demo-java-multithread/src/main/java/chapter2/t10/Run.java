package chapter2.t10;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 *
 但当上面的示例代码的格式运行在- server
 服务器模式中64bit的JwM上时,会出现死循
 环。解决的办法是使用 volatile关键字。

 */
public class Run {
    public static void main(String[] args) {
        PrintString printStringService = new PrintString();
        new Thread(printStringService).start();
        System.out.println("我要停止它 stopThread = " + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }
}
