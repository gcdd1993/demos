package chapter3.wait_notify_insert_test;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 *
 * 打印的效果是交替运行的。
 交替打印的原理就是使用如下代码作为标记:
 volatile private boolean prevIsA = false;
 实现了A和B线程交替备份的效果。
 */
public class Run {
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for(int i=0;i<20;i++) {
            BackupB output = new BackupB(dbTools);
            output.start();
            BackupA input = new BackupA(dbTools);
            input.start();
        }
    }
}
