package chapter3.p_r_test;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 * 本示例是1个生产者和1个消费者进行数据的交
 互,在控制台中打印的日志get和set是交替运行的。
 但如果在此实验的基础上,设计出多个生产者
 和多个消费者,那么在运行的过程中极有可能出现
 \u201c假死\u201d的情况,也就是所有的线程都呈WAITING
 等待状态。
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);
        ThreadP pThread = new ThreadP(p);
        ThreadC rThread = new ThreadC(r);
        pThread.start();
        rThread.start();
    }
}
