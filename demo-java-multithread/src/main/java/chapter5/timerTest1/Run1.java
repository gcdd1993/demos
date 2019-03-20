package chapter5.timerTest1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 * 1.执行任务的时间晚于当前时间:在未来执行的效果
 */
public class Run1 {
    private static Timer timer = new Timer();
    static public class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了！时间为:" + new Date());
        }
    }
    public static void main(String[] args) {
        try {
            MyTask task = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2017-10-12 11:55:00";
            Date dateRef = sdf.parse(dateString);
            System.out.println("字符串时间 : " + dateRef.toLocaleString() + "当前时间 : " + new Date().toLocaleString());
            timer.schedule(task,dateRef);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
