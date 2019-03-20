package chapter2.synOutAsyn;

/**
 * Created by gaochen on 2018/8/8.
 */
public class MyThreadA extends Thread {
    private MyList list;

    public MyThreadA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i=0;i< 10000;i++) {
            list.add("threadA" + (i + 1));
        }
    }
}
