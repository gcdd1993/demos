# 第一章 JAVA多线程技能
## 1.2 使用多线程
### 1.2.1 线程继承的方式
1.继承Thread类

	public class MyThread extends Thread {
	
	    @Override
	    public void run() {
	        super.run();
	        System.out.println("MyThread");
	    }
	
	    public static void main(String[] args) {
	        MyThread myThread = new MyThread();
	        myThread.start();
	        System.out.println("运行结束");
	    }
	}
2.实现Runnable接口

	public class MyRunnable implements Runnable {
	    @Override
	    public void run() {
	        System.out.println("运行中");
	    }
	
	    public static void main(String[] args) {
	        Runnable runnable = new MyRunnable();
	        Thread thread = new Thread(runnable);
	        thread.start();
	        System.out.println("运行结束");
	    }
	}

**【两种方式的区别】**

如果欲创建的线程类已经有一个父类了,这时就不能再继承自 Thread类了,因为Java
不支持多继承,所以就需要实现 Runnable接口来应对这样的情况。

使用继承 Thread类的方式来开发多线程应用程序在设计上是有局限性的,因为Java是
单根继承,不支持多继承,所以为了改变这种限制,可以使用实现 Runnable接口的方式来实现多线程技术。

### 1.2.2 实例变量与线程安全
自定义线程类中的实例变量针对其他线程可以有共享与不共享之分,这在多个线程之间
进行交互时是很重要的一个技术点

1.数据不共享情况

	public class MyThread1 extends Thread {
	    private int count = 5;
	
	    public MyThread1(String name) {
	        super();
	        this.setName(name);
	    }
	
	    @Override
	    public void run() {
	        super.run();
	        while (count > 0) {
	            count --;
	            System.out.println("由 " + currentThread().getName() + "计算,count = " + count);
	        }
	    }
	
	    public static void main(String[] args) {
	        MyThread1 a = new MyThread1("a");
	        MyThread1 b = new MyThread1("b");
	        MyThread1 c = new MyThread1("c");
	        a.start();
	        b.start();
	        c.start();
	    }
	}

控制台输出结果：

	由 c计算,count = 4
	由 b计算,count = 4
	由 a计算,count = 4
	由 b计算,count = 3
	由 c计算,count = 3
	由 b计算,count = 2
	由 a计算,count = 3
	由 b计算,count = 1
	由 c计算,count = 2
	由 b计算,count = 0
	由 a计算,count = 2
	由 c计算,count = 1
	由 a计算,count = 1
	由 c计算,count = 0
	由 a计算,count = 0

一共创建了3个线程,每个线程都有各自的 count变量,自己减少自己的 count变量的值。这样的情况就是变量不共享,此示例并不存在多个线程访问同一个实例变量的情况。

2.数据共享情况

	public class MyThread2 extends Thread {
	    private int count = 5;
	    @Override
	    public void run() {
	        super.run();
	        count --;
	        System.out.println("由 " + currentThread().getName() + "计算,count = " + count);
	    }
	
	    public static void main(String[] args) {
	        MyThread2 myThread2 = new MyThread2();
	        Thread a = new Thread(myThread2,"a");
	        Thread b = new Thread(myThread2,"b");
	        Thread c = new Thread(myThread2,"c");
	        Thread d = new Thread(myThread2,"d");
	        Thread e = new Thread(myThread2,"e");
	
	        a.start();
	        b.start();
	        c.start();
	        d.start();
	        e.start();
	
	    }
	
	}

控制台输出：

	由 a计算,count = 3
	由 b计算,count = 3
	由 c计算,count = 2
	由 d计算,count = 1
	由 e计算,count = 0

其实这个示例就是典型的销售场景:5个销售员,每个销售员卖出一个货品后不可以得
出相同的剩余数量,必须在每一个销售员卖完一个货品后其他销售员才可以在新的剩余物品
数上继续减1操作。这时就需要使多个线程之间进行同步,也就是用按顺序排队的方式进行
减1操作。

更改代码如下：

    synchronized public void run() {
        super.run();
        count --;
        System.out.println("由 " + currentThread().getName() + "计算,count = " + count);
    }

通过在run方法前加入synchronized关键字，使多个线程在执行run方法时，以排队的方式进行处理。当一个线程调用run前，先判断run方法有没有被上锁，如果上锁，说明有其他线程正在调用run方法，必须等其他线程对run方法调用结束后才可以执行run方法。这样也就实现了排队调用run方法的目的，也就达到了按顺序对count变量减1的效果了。

synchronized可以在任意对象及方法上加锁，而加锁的这段代码称为“互斥区”或“临界区”。当一个线程想要执行同步方法里面的代码时，线程首先尝试去拿这把锁，如果能够拿到这把锁，那么这个线程就可以执行synchronize里面的代码。如果不能拿到这把锁，那么这个线程就会不断地尝试拿这把锁，直到能够拿到为止，而且是有多个线程同时去争抢这把锁。

【非线程安全】非线程安全主要是指多个线程对同一个对象中
的同一个实例变量进行操作时会出现值被更改、值不同步的情况,进而影响程序的执行流
程。

非线程安全问题的解决方法：使用 synchronized关键字

构造一个非线程安全的常见场景--servlet

**servlet**

	public class LoginServlet {
	    private static String usernameRef;
	    private static String passwordRef;
	
	    synchronized public static void doPost(String username,String password) {
	        try {
	            usernameRef = username;
	            if(username.equals("a")) {
	                Thread.sleep(5000);
	                passwordRef = password;
	                System.out.println("username = " + usernameRef + " password = " + passwordRef);
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

**ALogin**

	public class ALogin extends Thread {
	    @Override
	    public void run() {
	        LoginServlet.doPost("a","aa");
	    }
	}

**BLogin**

	public class BLogin extends Thread {
	    @Override
	    public void run() {
	        LoginServlet.doPost("b","bb");
	    }
	}

**Run**

	public class Run {
	    public static void main(String[] args) {
	        ALogin a = new ALogin();
	        a.start();
	        BLogin b = new BLogin();
	        b.start();
	    }
	}

不使用synchronized关键词

	username = b password = aa
	username = a password = bb

有几率线程交叉

使用synchronized关键词解决非线程安全问题

	username = a password = aa
	username = b password = bb

### 1.2.3 Thread的常见方法


1. currentThread：返回代码段正在被哪个线程调用的信息。
2. isAlive：测试线程是否处于活动状态。什么是活动状态呢?活动状态就是线程已经启动且尚未终止。线程处于正在运行或准备开始运行的状态,就认为线程是“存活”的。
3. sleep：在指定的毫秒数内让当前“正在执行的线程”休眠(暂停执行)。这个“正在执行的线程”是指 this. currentthread返回的线程。
4. getId：取得线程的唯一标识。

### 1.2.4 停止线程的艺术

停止线程是在多线程开发时很重要的技术点,掌握此技术可以对线程的停止进行有效的
处理。停止线程在Java语言中并不像 break语句那样干脆,需要一些技巧性的处理。

在Java中有以下3种方法可以终止正在运行的线程

1. 使用退出标志,使线程正常退出,也就是当run方法完成后线程终止。
2. 使用stop方法强行终止线程,但是不推荐使用这个方法,因为stop和 suspend及
resume一样,都是作废过期的方法,使用它们可能产生不可预料的结果。
3. 使用 Interrupt方法中断线程

### 停止不了的线程

来看一段代码，执行500000次

	public class MyThread1 extends Thread {
	    @Override
	    public void run() {
	        super.run();
	        for(int i = 0;i < 500000;i++) {
	            System.out.println("i = " + (i + 1));
	        }
	    }
	
	    public static void main(String[] args) {
	        try {
	            MyThread1 thread = new MyThread1();
	            thread.start();
	            Thread.sleep(2000);
	            thread.interrupt();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

本示例将调用interrupt）方法来停止线程，但interrupt）方法的使用效果并不像
for+break语句那样，马上就停止循环。调用interrupt)方法仅仅是在当前线程中打了个停止的标记，并不是真的停止线程。从运行的结果来看，调用interrupt方法并没有停止线程。

### 判断线程是否是停止状态

1) interrupted:测试当前线程是否已经中断。

2) isInterrupted:测试线程是否已经中断。

测试当前线程是否已经中断，当前线程是指运行this.interrupted)方法的线程。

    public static void main(String[] args) {
        try {
            MyThread2 thread2 = new MyThread2();
            thread2.start();
            Thread.sleep(1000);
            thread2.interrupted();
            System.out.println("是否停止1 ? =" + thread2.isInterrupted());
            System.out.println("是否停止2 ? =" + thread2.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }

测试当前线程是否已经中断。线程的中断状态由该方法清除。换句话说，如果连续两次调用该方法，则第二次调用将返回false（在第一次调用已清除了其中断状态之后，且第二次调用检验完中断状态前，当前线程再次中断的情况除外）。

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1 ? =" + Thread.interrupted());
        System.out.println("是否停止2 ? =" + Thread.interrupted());
        System.out.println("end!");
    }

this.interupted():测试当前线程是否已经是中断状态，执行后具有将状态标志置清除为false的功能。

this.isInterrupted():测试线程Thread对象是否已经是中断状态，但不清除状态标志。

    public static void main(String[] args) {
        try {
            MyThread2 thread2 = new MyThread2();
            thread2.start();
            Thread.sleep(1000);
            thread2.interrupt();
            System.out.println("是否停止1 ? =" + thread2.isInterrupted());
            System.out.println("是否停止2 ? =" + thread2.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }


### 能停止的线程-异常法

有了前面学习过的知识点，就可在线程中用for语句来判断一下线程是否是停止状态，
如果是停止状态，则后面的代码不再运行即可。在判断过已经停止状态后，抛出InterruptedException异常，可及时停止线程。

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

### 在沉睡中停止线程

	public class MyThread4 extends Thread{
	    @Override
	    public void run() {
	        super.run();
	        try {
	            System.out.println("run begin");
	            Thread.sleep(200000);
	            System.out.println("run end");
	        } catch (InterruptedException e) {
	            System.out.println("在沉睡中被停止!进入catch！" + this.isInterrupted());
	            e.printStackTrace();
	        }
	    }
	
	    public static void main(String[] args) {
	        try {
	            MyThread4 thread = new MyThread4();
	            thread.start();
	            Thread.sleep(200);
	            thread.interrupt();
	        } catch (InterruptedException e) {
	            System.out.println("main catch");
	            e.printStackTrace();
	        }
	    }
	}

从打印的结果来看，如果在sleep状态下停止某一线程，会进入catch语句，并且清除停止状态值，使之变成false。前一个实验是先sleep然后再用interrupt停止，与之相反的操作在学习线程时也要注意。如下：

	public class MyThread5 extends Thread {
	    @Override
	    public void run() {
	        super.run();
	        try {
	            for (int i=0;i<100000;i++) {
	                System.out.println("i=" + (i+1));
	            }
	            System.out.println("run begin");
	            Thread.sleep(200000);
	            System.out.println("run end");
	        } catch (InterruptedException e) {
	            System.out.println("先停止,再遇到了sleep!进入catch!");
	            e.printStackTrace();
	        }
	    }
	
	    public static void main(String[] args) {
	        MyThread5 thread5 = new MyThread5();
	        thread5.start();
	        thread5.interrupt();
	        System.out.println("end!");
	    }
	}

### 能停止的线程——暴力停止

使用stop方法停止线程则是非常暴力的

	public class MyThread6 extends Thread {
	    private int i = 0;
	    @Override
	    public void run() {
	        try {
	            while (true) {
	                i++;
	                System.out.println("i=" + i);
	                Thread.sleep(1000);
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public static void main(String[] args) {
	        try {
	            MyThread6 thread6 = new MyThread6();
	            thread6.start();
	            Thread.sleep(8000);
	            thread6.stop();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

调用 stop方法时会抛出 java. lang Threaddeath异常,但在通常的情况下,此异常不需
要显式地捕捉。

	public class MyThread7 extends Thread {
	    @Override
	    public void run() {
	        try {
	            this.stop();
	        }catch (ThreadDeath e) {
	            System.out.println("进入了catch方法");
	            e.printStackTrace();
	        }
	    }
	
	    public static void main(String[] args) {
	        MyThread7 thread7 = new MyThread7();
	        thread7.start();
	    }
	}

方法 stop已经被作废,因为如果强制让线程停止则有可能使一些清理性的工作得不到完成。另外一个情况就是对锁定的对象进行了“解锁”,导致数据得不到同步的处理,出现数据不一致的问题。

### 释放锁的不良后果

使用 stop释放锁将会给数据造成不一致性的结果。如果出现这样的情况,程序处理的
数据就有可能遭到破坏,最终导致程序执行的流程错误,一定要特别注意

创建同步对象SynchronizedObject：

	public class SynchronizedObject {
	    private String username = "a";
	    private String password = "aa";
	
	    public String getUsername() {
	        return username;
	    }
	
	    public void setUsername(String username) {
	        this.username = username;
	    }
	
	    public String getPassword() {
	        return password;
	    }
	
	    public void setPassword(String password) {
	        this.password = password;
	    }
	
	    synchronized public void printString(String username,String password) {
	        try {
	            this.username = username;
	            Thread.sleep(100000);
	            this.password = password;
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

创建执行线程

	public class MyThread8 extends Thread {
	    private SynchronizedObject object;
	
	    public MyThread8(SynchronizedObject object) {
	        super();
	        this.object = object;
	    }
	
	
	    @Override
	    public void run() {
	        object.printString("b","bb");
	    }
	
	    public static void main(String[] args) {
	        try {
	            SynchronizedObject object = new SynchronizedObject();
	            MyThread8 thread8 = new MyThread8(object);
	            thread8.start();
	            Thread.sleep(500);
	            thread8.stop();
	            System.out.println(object.getUsername() + " " + object.getPassword());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

控制台输出结果：

	b aa

由于 stop方法已经在JDK中被标明是“作废/过期”的方法,显然它在功能上具有缺陷,所以不建议在程序中使用 stop方法。

### 使用return停止线程

将方法 Interrupt0与 return结合使用也能实现停止线程的效果。

	public class MyThread9 extends Thread {
	    @Override
	    public void run() {
	        while (true) {
	            if(this.isInterrupted()) {
	                System.out.println("停止了");
	                return;
	            }
	            System.out.println("timer : " + System.currentTimeMillis());
	        }
	    }
	
	    public static void main(String[] args) throws InterruptedException {
	        MyThread9 thread9 = new MyThread9();
	        thread9.start();
	        Thread.sleep(2000);
	        thread9.interrupt();
	    }
	}

不过还是建议使用“抛异常”的方法来实现线程的停止,因为在catch块中还可以将异常向上抛,使线程停止的事件得以传播。

### 暂停线程

暂停线程意味着此线程还可以恢复运行。在Java多线程中,可以使用 suspend方法暂停线程,使用 resumed方法恢复线程的执行。

### suspend与 resume方法的使用
	public class MyThread10 extends Thread {
	    private long i = 0;

	    public long getI() {
	        return i;
	    }

	    public void setI(long i) {
	        this.i = i;
	    }

	    @Override
	    public void run() {
	        while (true) {
	            i++;
	        }
	    }

	    public static void main(String[] args) {
	        try {
	            MyThread10 thread10 = new MyThread10();
	            thread10.start();
	            Thread.sleep(5000);
	            //A
	            thread10.suspend();
	            System.out.println("A = " + System.currentTimeMillis() + "i= " + thread10.getI());
	            Thread.sleep(5000);
	            System.out.println("A = " + System.currentTimeMillis() + "i= " + thread10.getI());
	            //B
	            thread10.resume();
	            Thread.sleep(5000);
	            thread10.suspend();
	            System.out.println("B = " + System.currentTimeMillis() + "i= " + thread10.getI());
	            Thread.sleep(5000);
	            System.out.println("B = " + System.currentTimeMillis() + "i= " + thread10.getI());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

控制台会输出以下内容：

	A = 1533659891007i= 2728593828
	A = 1533659896008i= 2728593828
	B = 1533659901008i= 5573928202
	B = 1533659906009i= 5573928202

从控制台打印的时间上来看,线程的确被暂停了而且还可以恢复成运行的状态。

### suspend与 resume方法的缺点
独占：在使用 suspend与 resume方法时,如果使用不当,极易造成公共的同步对象的独占,使得其他线程无法访问公共同步对象。

不同步：在使用 suspend与 resume方法时也容易出现因为线程的暂停而导致数据不同步的情况。

### yield方法

yield方法的作用是放弃当前的CPU资源,将它让给其他的任务去占用CPU执行时
间。但放弃的时间不确定,有可能刚刚放弃,马上又获得CPU时间片。

	public class MyThread extends Thread {
	    @Override
	    public void run() {
	        long beginTime = System.currentTimeMillis();
	        int count = 0;
	        for(int i=0;i<50000000;i++) {
	            Thread.yield();
	            count = count + (i + 1);
	        }
	        long endTime = System.currentTimeMillis();
	        System.out.println("用时 : " + (endTime - beginTime) + "毫秒");
	    }
	
	    public static void main(String[] args) {
	        MyThread thread = new MyThread();
	        thread.start();
	    }
	}

注释Thread.yield(); 

	用时 : 23毫秒

放开Thread.yield();

	用时 : 16763毫秒

将CPU让给其他资源导致速度变慢

### 线程的优先级

在操作系统中,线程可以划分优先级,优先级较高的线程得到的CPU资源较多,也就是CPU优先执行优先级较高的线程对象中的任务。设置线程优先级有助于帮“线程规划器”确定在下一次选择哪一个线程来优先执行。设置线程的优先级使用 setpriority()方法。

在Java中,线程的优先级分为1~10这10个等级,如果小于1或大于10,则JDK抛出异常 throw new Illegalargument Exception。

JDK中使用3个常量来预置定义优先级的值,代码如下:

	public final static int MIN PRIORITY 1;
	public final static int NORM PRIORITY = 5;
	public final static int MAX PRIORITY 10;

【线程优先级的特性】

1.**继承性**：在Java中，线程的优先级具有继承性，比如A线程启动B线程，则B线程的优先级与A是一样的。

2.**规则性**：高优先级的线程总是大部分先执行完，但不代表高优先级的线程全部先执行完。另外，不要以为MyThread1线程先被main 线程所调用就会先执行完，出现这样的结果全是因为MyThread1线程的优先级是最高值为10造成的。当线程优先级的等级差距很大时，谁先执行完和代码的调用顺序无关。

3.**随机性**：线程的优先级较高则优先执行完runO方法中的任务，但这个结果不能
说的太肯定，因为线程的优先级还具有“随机性”，也就是优先级较高的线程不一定每一次都先执行完。

优先级高的运行的快

### 守护线程

在Java线程中有两种线程，一种是用户线程，另一种是守护线程。

> 守护线程是一种特殊的线程，它的特性有“陪伴”的含义，当进程中不存在非守护线程了，则守护线程自动销毁。典型的守护线程就是垃圾回收线程，当进程中没有非守护线程了，则垃圾回收线程也就没有存在的必要了，自动销毁。用个比较通俗的比喻来解释一下“守护线程”：任何一个守护线程都是整个JVM中所有非守护线程的“保姆”，只要当前JVM实例中存在任何一个非守护线程没有结束，守护线程就在工作，只有当最后一个非守护线程结束时，守护线程才随着JVM一同结束工作。Daemon的作用是为其他线程的运行提供便利服务，守护线程最典型的应用就是GC（垃圾回收器），它就是一个很称职的守护者。





