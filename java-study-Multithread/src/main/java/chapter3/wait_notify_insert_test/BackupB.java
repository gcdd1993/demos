package chapter3.wait_notify_insert_test;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class BackupB extends Thread {
    private DBTools dbTools;

    @Override
    public void run() {
        dbTools.backupB();
    }
}
