package chapter3.stack_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 7,多生产与多消费:操作栈
 本示例是使用生产者向栈List对象中放入
 数据,使用消费者从List栈中取出数据。List最
 大容量是1,实验环境是多个生产者与多个消
 费者。
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
