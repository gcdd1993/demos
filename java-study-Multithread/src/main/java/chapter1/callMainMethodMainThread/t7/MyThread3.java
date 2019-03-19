package chapter1.callMainMethodMainThread.t7;

/**
 * Created by gaochen on 2018/8/7.
 * 1.7.3能停止的线程——异常法
 *
 * 有了前面学习过的知识点，就可在线程中用for语句来判断一下线程是否是停止状态，
 * 如果是停止状态，则后面的代码不再运行即可。
 */
public class MyThread3 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for(int i = 0;i < 500000;i++) {
                if(this.isInterrupted()) {
                    System.out.println("已经停止状态!");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }
            //该如何解决语句继续运行的问题呢?
            System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止");
        }catch (InterruptedException ex) {
            System.out.println("进MyThread.java 类run方法中的catch");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread3 thread3 = new MyThread3();
            thread3.start();
            Thread.sleep(2000);
            thread3.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
