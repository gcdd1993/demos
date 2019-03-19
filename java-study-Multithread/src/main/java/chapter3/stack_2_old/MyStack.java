package chapter3.stack_2_old;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 本示例是使生产者向堆栈List对象中放入数据,使消费者从List堆栈中取出数据。List
 最大容量是1,实验环境只有一个生产者与一个消费者。

 运行项目没有出现执行异常,却出现
 了\u201c假死\u201d情况,如图3-34所示。
 解决的办法当然还是使用notifyAll()
 方法了。
 */
public class MyStack {
    private List list = new ArrayList();
    synchronized public void push() {
        try {
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyString = " + Math.random());
            this.notifyAll();
            System.out.println("push = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                System.out.println("pop method " + Thread.currentThread().getName() + " 线程呈wait 状态");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notifyAll();
            System.out.println("pop = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
