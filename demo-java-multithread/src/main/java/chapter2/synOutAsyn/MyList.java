package chapter2.synOutAsyn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyList {
    private List list = new ArrayList();
    synchronized public void add(String username) {
        System.out.println("Thread Name = " + Thread.currentThread().getName() + "执行了add 方法");
        list.add(username);
        System.out.println("Thread Name = " + Thread.currentThread().getName() + "退出了add方法");
    }
    synchronized public int getSize() {
        System.out.println("Thread Name = " + Thread.currentThread().getName() + "执行了getSize 方法");
        int size = list.size();
        System.out.println("Thread Name = " + Thread.currentThread().getName() + "退出了getSize方法");
        return size;
    }
}
