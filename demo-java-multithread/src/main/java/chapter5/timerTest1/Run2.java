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
 * Timer Task是以队列的方式一个一个被顺序执行的,所以执行的时间有可能和预期的时
 间不一致,因为前面的任务有可能消耗的时间较长,则后面的任务运行的时间也会被延迟。
 */
public class Run2 {
    private static Timer timer = new Timer();
    static public class MyTask1 extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了！时间为:" + new Date());
        }
    }
    static public class MyTask2 extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了！时间为:" + new Date());
        }
    }

    public static void main(String[] args) {
        try {
            MyTask1 task1 = new MyTask1();
            MyTask2 task2 = new MyTask2();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String dateString1 = "2017-10-12 11:55:00";
            String dateString2 = "2017-10-13 11:55:00";

            Date dateRef1 = sdf1.parse(dateString1);
            Date dateRef2 = sdf2.parse(dateString2);

            System.out.println("字符串时间 : " + dateRef1.toLocaleString() + "当前时间 : " + new Date().toLocaleString());
            System.out.println("字符串时间 : " + dateRef2.toLocaleString() + "当前时间 : " + new Date().toLocaleString());

            timer.schedule(task1,dateRef1);
            timer.schedule(task2,dateRef2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
