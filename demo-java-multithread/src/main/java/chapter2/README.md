# 第一章 对象及变量的并发访问

本章主要介绍Java多线程中的同步，也就是如何在Java语言中写出线程安全的程序，如何在Java语言中解决非线程安全的相关问题。多线程中的同步问题是学习多线程的重中之重，这个技术在其他的编程语言中也涉及，如C++或C#。

本章应该着重掌握如下技术点：

- synchronized对象监视器为Object时的使用。
- synchronized对象监视器为Class时的使用。
- 非线程安全是如何出现的。
- 关键字volatile的主要作用。
- 关键字volatile与synchronized的区别及使用情况。

## 2.1 synchronized同步方法
### 2.1.1方法内的变量为线程安全

[实例代码-t5](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/t5)

“非线程安全”问题存在于“实例变量”中，如果是方法内部的私有变量，则不存在“非
线程安全”问题，所得结果也就是“线程安全”的了。

### 2.1.2 实例变量非线程安全

[实例代码-synchronizedOneThreadIn](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/synchronizedOneThreadIn)

如果多个线程共同访问1个对象中的实例变量，则有可能出现“非线程安全”问题。用线程访问的对象中如果有多个实例变量，则运行的结果有可能出现交叉的情况。此情况在第1章中非线程安全的案例演示过。

如果对象仅有1个实例变量，则有可能出现覆盖的情况。

在两个线程访问同一个对象中的同步方法时一定是线程安全的。本实验由于是同步访问，所以先打印出a，然后打印出b。

### 2.1.3 多个对象多个锁

[实例代码-twoObjectTwoLock](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/twoObjectTwoLock)

上面示例是两个线程分别访问同一个类的两个不同实例的相同名称的同步方法，效果却是以异步的方式运行的。本示例由于创建了2个业务对象，在系统中产生出2个锁，所以运行结果是异步的，打印的效果就是先打印b，然后打印a。

从上面程序运行结果来看，虽然在HasSelfPrivateNum.java中使用了synchronized关键字，但打印的顺序却不是同步的，是交叉的。为什么是这样的结果呢?

关键字synchronized取得的锁都是对象锁，而不是把一段代码或方法（函数）当作锁，所以在上面的示例中，哪个线程先执行带 synchronized关键字的方法，哪个线程就持有该方法所属对象的锁Lock，那么其他线程只能呈等待状态，前提是多个线程访问的是同一个对象。

但如果多个线程访问多个对象，则JVM会创建多个锁。上面的示例就是创建了2个HasSelfPrivateNum.java类的对象，所以就会产生出2个锁。

### 2.1.4 synchronized 方法与锁对象

[实例代码-synchronizedMethodLockObject](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/synchronizedMethodLockObject)

1）A线程先持有object对象的Lock锁，B线程可以以异步的方式调用object对象中的
非synchronized类型的方法。

2）A线程先持有object对象的Lock锁，B线程如果在这时调用object对象中的synchronized
类型的方法则需等待，也就是同步。

### 2.1.5 脏读

当A线程调用anyObject对象加入synchronized关键字的X方法时，A线程就获得了X
方法锁，更准确地讲，是获得了对象的锁，所以其他线程必须等A线程执行完毕才可以调用
X方法，但B线程可以随意调用其他的非synchronized同步方法。

当A线程调用anyObject对象加入synchronized关键字的X方法时，A线程就获得了X
方法所在对象的锁，所以其他线程必须等A线程执行完毕才可以调用X方法，而B线程如
果调用声明了synchronized关键字的非X方法时，必须等A线程将X方法执行完，也就是
释放对象锁后才可以调用。这时A线程已经执行了一个完整的任务，也就是说username和
password这两个实例变量已经同时被赋值，不存在脏读的基本环境。

脏读一定会出现操作实例变量的情况下，这就是不同线程“争抢”实例变量的结果。

### 2.1.6 synchronized锁重入

[实例代码-synLockIn_1](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/synLockIn_1)
[实例代码-synLockIn_2](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/synLockIn_2)

关键字synchronized拥有锁重入的功能，也就是在使用synchronized时，当一个线程得到一个对象锁后，再次请求此对象锁时是可以再次得到该对象的锁的。这也证明在一个synchronized方法/块的内部调用本类的其他synchronized方法/块时，是永远可以得到锁的。

“可重入锁”的概念是：自己可以再次获取自己的内部锁。比如有1条线程获得了某个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的，如果不可锁重入的话，就会造成死锁。

可重入锁也支持在父子类继承的环境中。当存在父子类继承关系时，子类是完全可以通过“可重入锁”调用父类的同步方法的。

### 2.1.7 出现异常，锁自动释放

[实例代码-throwExceptionNoLock](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/throwExceptionNoLock)

当一个线程执行的代码出现异常时,其所持有的锁会自动释放。

### 2.1.8 同步不具有继承性

[实例代码-synNotExtends](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/synNotExtends)

同步不可以继承。

## 2.2 synchronized同步语句块

用关键字 synchronized声明方法在某些情况下是有弊端的,比如A线程调用同步方法执行一个长时间的任务,那么B线程则必须等待比较长时间。

在这样的情况下可以使用synchronized同步语句块来解决。

当一个线程访问object的一个synchronized同步代码块时,另一个线程仍然可以访问该 object对象中的非 synchronized( this同步代码块。不在synchronized块中就是异步执行,在synchronized块就是同步执行。

### 2.2.5 synchronized代码块间的同步性

[实例代码-doubleSynBlockOneTwo](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/doubleSynBlockOneTwo)

在使用同步 synchronized(this代码块时需要注意的是,当一个线程访问 object的一synchronized(this同步代码块时,其他线程对同一个 object中所有其他 synchronized (this同步代码块的访问将被阻塞,这说明 synchronized使用的“对象监视器”是一个。

### 2.2.7 将任意对象作为对象监视器

使用“ synchronized非this对象x)同步代码块”格式进行同步操作时,对象监视器必须是同一个对象。如果不是同一个对象监视器,运行的结果就是异步调用了,就会交叉运行。

**【总结】**

- 当多个线程同时执行 synchronized(x){}同步代码块时呈同步效果。
- 当其他线程执行x对象中 synchronized同步方法时呈同步效果。
- 当其他线程执行x对象方法里面的 synchronized(this)代码块时也呈现同步效果。

但需要注意:如果其他线程调用不加 synchronized关键字的方法时,还是异步调用。

### 2.2.9 静态同步 synchronized方法与 synchronized( class)代码块

[实例代码-synStaticMethod](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/synStaticMethod)

关键字synchronized还可以应用在static静态方法上,如果这样写,那是对当前的*.java文件对应的Class类进行持锁

从运行结果来看,并没有什么特别之处,都是同步的效果,和将 synchronized关键字加到非static方法上使用的效果是一样的。其实还是有本质上的不同的, synchronized关键字加到 static静态方法上是给class类上锁,而 synchronized关键字加到非 static静态方法上是给对象上锁。

### 2.2.10数据类型 String的常量池特性

[实例代码-stringAndSyn](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/stringAndSyn)

出现这样的情况就是因为 String的两个值都是AA,两个线程持有相同的锁,所以造成线程B不能执行。这就是 String常量池所带来的问题。因此在大多数的情况下,同步synchronized代码块都不使用 String作为锁对象,而改用其他,比如 new Object()实例化一个Object对象,但它并不放入缓存中。

### 2.2.11同步 synchronized方法无限等待与解决

[实例代码-twoStop](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/twoStop)

同步方法容易造成死循环。

### 2.2.12多线程的死锁

[实例代码-deadLockTest](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/deadLockTest)

Java线程死锁是一个经典的多线程问题,因为不同的线程都在等待根本不可能被释放的锁,从而导致所有的任务都无法继续完成。在多线程技术中,“死锁”是必须避免的,因为这会造成线程的“假死”。

可以使用JDK自带的工具来监测是否有死锁的现象。首先进入CMD工具,再进入JDK
的安装文件夹中的bin目录,执行jps命令，如下图

![](https://i.imgur.com/mkdKIua.png)

得到运行的线程Run的id值是9796。再执行 stack命令(jstack -l 9796),查看结果,如下图:

![](https://i.imgur.com/t7Grn7p.png)

监测出有死锁现象,如上图所示。死锁是程序设计的Bug,在设计程序时就要避免双方互相持有对方的锁的情况。需要说明的是,本实验使用 synchronized嵌套的代码结构来实现死锁,其实不使用嵌套的 synchronized代码结构也会出现死锁,与嵌套不嵌套无任何的关系,不要被代码结构所误导。只要互相等待对方释放锁就有可能出现死锁。

### 2.2.13内置类与静态内置类

[实例代码-innerClass](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/innerClass)
[实例代码-innerStaticClass](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/innerStaticClass)

关键字 synchronized的知识点还涉及内置类的使用。先来看一下简单的内置类的测试。

### 2.2.16锁对象的改变

在将任何数据类型作为同步锁时,需要注意的是,是否有多个线程同时持有锁对象,如果同时持有相同的锁对象,则这些线程之间就是同步的;如果分别获得锁对象,这些线程之间就是异步的。

## 2.3 volatille关键字

关键字 volatile的主要作用是使变量在多个线程间可见。

### 2.3.1 关键字 volatile（不支持原子性）与死循环

[实例代码-t99](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/t99)

如果不是在多继承的情况下,使用继承 Thread类和实现 Runnable接口在取得程序运行
的结果上并没有什么太大的区别。如果一旦出现“多继承”的情况,则用实现 Runnable接口
的方式来处理多线程的问题就是很有必要的。

**【同步死循环】**关键字 volatile的作用是强制从公共堆栈中取得变量的值,而不是从线程私有数据栈中
取得变量的值。

[实例代码-t10](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/t10)

**【异步死循环】**这个问题其实就是私有堆栈中的值和公共堆栈中的值不同步造成的。解决这样的问题就要使用 volatile关键字了,它主要的作用就是当线程访问 isrunning这个变量时,强制性从公
共堆栈中进行取值。

内存结构如图：

![](https://i.imgur.com/HECOky4.png)

下面将关键字 synchronized和 volatile进行一下比较:

- 关键字 volatile是线程同步的轻量级实现,所以 volatile性能肯定比 synchronized要
好,并且 volatile只能修饰于变量,而 synchronized可以修饰方法,以及代码块。随着JDK
新版本的发布, synchronized关键字在执行效率上得到很大提升,在开发中使用 synchronized
关键字的比率还是比较大的。

- 多线程访问 volatile不会发生阻塞,而 synchronized会出现阻塞。

- volatile能保证数据的可见性,但不能保证原子性;而 synchronized可以保证原子性,
也可以间接保证可见性,因为它会将私有内存和公共内存中的数据做同步。此知识点在后面
有实验做论证。

- 再次重申一下,关键字 volatile解决的是变量在多个线程之间的可见性;而 synchronized关键字解决的是多个线程之间访问资源的同步性。
线程安全包含原子性和可见性两个方面,Java的同步机制都是围绕这两个方面来确保线
程安全的。

### 2.3.4 volatile 非原子的特性

[实例代码-volatileTestThread](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/volatileTestThread)

关键字 volatile主要使用的场合是在多个线程中可以感知实例变量
被更改了,并且可以获得最新的值使用,也就是用多线程读取共享变
量时可以获得最新值使用。

用图来演示一下使用关键字 volatile时出现非线程安全的原因。变量在内存中工作的过
程如图所示。
由上,我们可以得出以下结论。
1)read和load阶段:从主存复制变量到当前线程工作内存;
2)use和 assign阶段:执行代码,改变共享变量值;
3) store和 write阶段:用工作内存数据刷新主存对应变量的值。

![](https://i.imgur.com/4fLRmCm.png)

在多线程环境中，use和assign是多次出现的，但这一操作并不是原子性，也就是在
read和load之后，如果主内存count变量发生修改之后，线程工作内存中的值由于已经加
载，不会产生对应的变化，也就是私有内存和公共内存中的变量不同步，所以计算出来的结
果会和预期不一样，也就出现了非线程安全问题。

对于用volatile修饰的变量，JVM虚拟机只是保证从主内存加载到线程工作内存的值是
最新的，例如线程1和线程2在进行read和load的操作中，发现主内存中count的值都是
5，那么都会加载这个最新的值。也就是说，volatile关键字解决的是变量读时的可见性问题，
但无法保证原子性，对于多个线程访问同一个实例变量还是需要加锁同步。

### 2.3.5 使用原子类进行i++操作

[实例代码-atomicIntegerTest](https://github.com/qq1398371419/Java-Multi-thread-Programming/tree/master/src/main/java/chapter2/atomicIntegerTest)

除了在i计+操作时使用synchronized关键字实现同步外，还可以使用AtomicInteger原子
类进行实现。
原子操作是不能分割的整体，没有其他线程能够中断或检查正在原子操作中的变量。一
个原子(atomic)类型就是一个原子操作可用的类型，它可以在没有锁的情况下做到线程安全
（thread-safe)。

### 2.3.7 synchronized 代码块有 volatile同步的功能

关键字synchronized可以使多个线程访问同一个资源具有同步性，而且它还具有将线程
工作内存中的私有变量与公共内存中的变量同步的功能。

关键字synchronized可以保证在同一时刻，只有一个线程可以执行某一个方法或某一个
代码块。它包含两个特征：互斥性和可见性。同步synchronized不仅可以解决一个线程看到
对象处于不一致的状态，还可以保证进入同步方法或者同步代码块的每个线程，都看到由同
一个锁保护之前所有的修改效果。

学习多线程并发，要着重“外练互斥，内修可见”，这是掌握多线程、学习多线程并发
的重要技术点。


