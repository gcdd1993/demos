package chapter1.callMainMethodMainThread.t6;

/**
 * Created by gaochen on 2018/8/7.
 *
 * 虽然在上面的示例中打印的值是true,但此值是不确定的。打印tue值是因为 mythread
 * 线程还未执行完毕,所以输出true。如果代码更改如下:
 *
 * 则上述代码运行的结果输出为 false,因为 mythread对象已经在1秒之内执行完毕。
 * 另外,在使用 salive方法时,如果将线程对象以构造参数的方式传递给 Thread对象
 * 进行 start启动时,运行的结果和前面示例是有差异的。造成这样的差异的原因还是来自于
 * Thread. current Thread和this的差异。下面测试一下这个实验。
 */
public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("CountOperate--begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("CountOperate--end");
    }

    @Override
    public void run() {
        System.out.println("CountOperate--begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("CountOperate--end");
    }

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive = " + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive = " + t1.isAlive());
    }
}
