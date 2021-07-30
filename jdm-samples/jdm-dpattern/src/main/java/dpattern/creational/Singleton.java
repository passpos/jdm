/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern.creational;

/**
 * 单例模式
 * 系统中只需要一个全局的实例，比如一些工具类，Converter，SqlSession等。
 *
 * a.饿汉式
 * 属性字段的初始值不为 null，或者类中包含静态代码块，用于初始化属性字段。线程安全；
 *
 * b.懒汉式
 * 属性字段的初始值为 null。线程不安全，但可以通过同步锁解决问题；
 *
 * c.静态内部类
 * 通过在单例类中放置一个静态内部类，而该内部类中放置一个预初始化的属性字段，用于存放单例；
 * 这种方式，除了结构稍微复杂一点，没有其他缺点。
 *
 * d.枚举类
 * 枚举实例不能被重复创建，这一点可以用于单例模式，但枚举类自身内部不能存储数据。
 *
 * e.双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 * 共有问题
 * 并没有绝对完美的单例方案。无论哪种方案，都或多或少有些小问题，需要视情况去妥协。
 *
 * 例如：
 *
 * 1.凡是存储在类的属性字段上的成员，都可以通过反射的方式获取类的新的实例；
 * - 但枚举类型可以避免该问题；
 *
 * 2.使用序列化+反序列化的方式，获取到的实例总是新实例。
 * - 当然，这要求 Singleton 实现序列化接口。不去实行序列化接口，自然就没有问题了；
 *
 * 意图：
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 *
 * 主要解决：
 * 一个全局使用的类频繁地创建与销毁。
 *
 * 何时使用：
 * 当您想控制实例数目，节省系统资源的时候。
 *
 * 如何解决：
 * 判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 *
 * 关键代码：
 * 构造函数是私有的。
 *
 * 应用实例：
 * 1.一个班级只有一个班主任。
 * 2.Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个
 * 文件的现象，所以所有文件的处理必须通过唯一的实例来进行。
 * 3.一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印
 * 机打印同一个文件。
 *
 * 优点：
 * 1.在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓
 * 存）。
 * 2.避免对资源的多重占用（比如写文件操作）。
 *
 * 缺点：
 * 没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
 *
 * 使用场景：
 *
 * 1.要求生产唯一序列号。
 * 2.WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。
 * 3.创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
 *
 * 注意事项：
 * getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入
 * 造成 instance 被多次实例化。
 *
 * @author passpos <paiap@outlook.com>
 */
public class Singleton {

    /**
     * 静态存储自身实例
     *
     * volatile 关键字，保证了 instance 属性是共享属性。
     * 在多线程环境下，初始执行 getInstance() 时，有可能会获取到不同的实例。
     * volatile 保证了 getInstance() 方法创建实例后，该实例会被（从CPU）立即更新到内存，同时
     * 通知到其他线程；
     */
    private volatile static Singleton instance = null;

    /**
     * 私有化构造方法，阻止其他程序创建新实例；
     */
    private Singleton() {

    }

    /**
     * 静态获取自身实例
     * 下面使用了同步锁的方式，创建并更新 instance 属性。
     *
     * 双重检查锁（Double-Checked Locking）
     * 在同步锁外部，执行一次检查，从而避免多次调用 getInstance() 时，都要执行一次同步；
     * 在同步锁内部，执行一次检查，从而避免可能不必要的执行。
     * 因为有时即使进入了同步锁，但在第一次检查之后，进入同步之前，instance 被创建了。此时，不必
     * 再执行实例化操作；
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
