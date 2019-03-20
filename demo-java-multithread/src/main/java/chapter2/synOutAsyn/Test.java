package chapter2.synOutAsyn;

/**
 * Created by gaochen on 2018/8/8.
 */
public class Test {
    public static void main(String[] args) {
        MyList myList = new MyList();
        MyThreadA a = new MyThreadA(myList);
        a.setName("a");
        a.start();
        MyThreadB b = new MyThreadB(myList);
        b.setName("b");
        b.start();
    }
}
