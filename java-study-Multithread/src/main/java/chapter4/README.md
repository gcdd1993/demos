# 第4章 Lock的使用

本章将要介绍使用Java5中Lock对象也能实现同步的效果，而且在使用上更加方便。
本章着重掌握如下2个知识点：
- ReentrantLock类的使用。
- ReentrantReadWriteLock类的使用。

## 4.1使用ReentrantLock类

在Java多线程中，可以使用synchronized关键字来实现线程之间同步互斥，但在JDK1.5中新增加了ReentrantLock类也能达到同样的效果，并且在扩展功能上也更加强大，比如具有嗅探锁定、多路分支通知等功能，而且在使用上也比synchronized更加的灵活。

### 4.1.9公平锁与非公平锁

公平与非公平锁:锁Iock分为“公平锁”和“非公平锁”,公平锁表示线程获取锁的顺序是按照线程加锁的顺序来分配的,即先来先得的FIFO先进先出顺序。而非公平锁就是种获取锁的抢占机制,是随机获得锁的,和公平锁不一样的就是先来的不一定先得到锁,这个方式可能造成某些线程一直拿不到锁,结果也就是不公平的了。

### ReentrantLock类 方法解析

- int getHoldCount()的作用是查询当前线程保持此锁定的个数，也就是调用lock方法的次数
- int getQueueLength()的作用是返回正等待获取此锁定的线程估计数，比如有5个线程，1个线程首先执行await)方法，那么在调用getQueueLength（)方法后返回值是4，说明有4个线程同时在等待lock的释放。
- int getWaitQueueLength（Condition condition)的作用是返回等待与此锁定相关的给定条件Condition的线程估计数，比如有5个线程，每个线程都执行了同一个condition对象的await()方法，则调用getWaitQueueLength(Condition condition)方法时返回的int值是5。

- boolean hasQueuedThread（Thread thread)的作用是查询指定的线程是否正在等待获取此锁定。
- boolean hasQueuedThreads)的作用是查询是否有线程正在等待获取此锁定。
- boolean hasWaiters（Condition condition)的作用是查询是否有线程正在等待与此锁定有关的condition条件。

- boolean isFair()的作用是判断是不是公平锁。
- boolean isHeldByCurrentThread()的作用是査询当前线程是否保持此锁定。
- boolean islockedo的作用是查询此锁定是否由任意线程保持。

- void lockinterruptibly()的作用是:如果当前线程未被中断,则获取锁定,如果已经被中断则出现异常。
- boolean tryLock()的作用是,仅在调用时锁定未被另一个线程保持的情况下,才获取该锁定。
- boolean try Lock(long timeout, TimeUnit unit)的作用是,如果锁定在给定等待时间内没有被另一个线程保持,且当前线程未被中断,则获取该锁定。

## 4.2使用 Reentrantread Writelock类
类 Reentrantlock具有完全互斥排他的效果,即同一时间只有一个线程在执行Reentrantlock locko方法后面的任务。这样做虽然保证了实例变量的线程安全性,但效率却是非常低下的。所以在JDK中提供了一种读写锁 Reentrantread writelock类,使用它可以加快运行效率,在某些不需要操作实例变量的方法中,完全可以使用读写锁Reentrant Read writelock来提升该方法的代码运行速度。

读写锁表示也有两个锁,一个是读操作相关的锁,也称为共享锁;另一个是写操作相关的锁,也叫排他锁。也就是多个读锁之间不互斥,读锁与写锁互斥,写锁与写锁互斥。在没有线程 Thread进行写入操作时,进行读取操作的多个 Thread都可以获取读锁,而进行写入操作的 Thread只有在获取写锁后才能进行写入操作。即多个 Thread可以同时进行读取操作,但是同一时刻只允许一个 Thread进行写入操作。

“读写”、“写读”和“写写”都是互斥的；而“读读”是异步的，非互斥的。