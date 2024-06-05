package top.caibitv.demo.design;

/**
 * 内部类懒加载(线程安全)
 *
 * 使用类的静态内部类实现的单例模式，既保证了线程安全又保证了懒加载，同时不会因为加锁的方式耗费性能。
 * 这主要是因为JVM虚拟机可以保证多线程并发访问的正确性，也就是一个类的构造方法在多线程环境下可以被正确的加载。
 * 此种方式也是非常推荐使用的一种单例模式
 *
 * 静态内部类的加载和初始化有以下特点：
 * 1.独立加载：静态内部类只有在被使用时才会被加载和初始化。这意味着外部类的加载和初始化不会导致静态内部类的加载。
 * 2.线程安全：类的加载过程在JVM中是线程安全的，即类的加载和初始化在同一个类加载器的多个线程中只会发生一次。
 */
public class Singleton_04 {

    private static class SingletonHolder {
        private static final Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }
}
