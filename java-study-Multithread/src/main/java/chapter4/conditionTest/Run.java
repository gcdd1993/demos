package chapter4.conditionTest;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 *
 * 根据第3章中的 notifyallo解决方案,可以使用 signalallo方法来解决。将 My test1
 java类中两处 signalo代码改成 signalallo后,程序得到正确运行,效果如图416所示。
 从控制台打印的日志可以发现,运行后不再出现假死状态,假死问题被解决了。
 控制台中“打印★”和“打印☆”是交替输出的,但是“有可能★★连续”和“有可
 能☆☆连续”却不是交替输出的,有时候出现连续打印的情况。原因是程序中使用了一个
 Condition对象,再结合 signalallo方法来唤醒所有的线程,那么唤醒的线程就有可能是同
 类,所以就出现连续打印“有可能★★连续”或“有可能☆☆连续”的情况了。
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA[] threadAS = new ThreadA[10];
        ThreadB[] threadBS = new ThreadB[10];
        for(int i=0;i<10;i++) {
            threadAS[i] = new ThreadA(service);
            threadBS[i] = new ThreadB(service);
            threadAS[i].start();
            threadBS[i].start();
        }
    }
}
