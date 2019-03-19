package multithread;

import org.junit.Test;

/**
 * @author: gaochen
 * Date: 2019/1/30
 * 启动两个线程, 一个输出 1,3,5,7…99, 另一个输出 2,4,6,8…100 最后 STDOUT 中按序输出 1,2,3,4,5…100
 */
public class Demo1 {
    @Test
    public void test1() {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }

    static class ThreadA extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 1) {
                    System.out.println("线程A : " + i);
                }
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 1) {
                    System.out.println("线程A : " + i);
                }
                this.notifyAll();
            }
        }
    }
}
