package top.caibitv.demo.design;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS(线程安全) AtomicReference
 *
 * 使用CAS的好处就是不需要使用传统的加锁方式保证线程安全，而是依赖于CAS的忙等算法，依赖于底层硬件的实现，来保证线程安全。
 * 相对于其他锁的实现没有线程的切换和阻塞也就没有了额外的开销，并且可以支持较大的并发性。
 */
public class Singleton_06 {

    private static AtomicReference<Singleton_06> INSTANCE = new AtomicReference<Singleton_06>();

    private Singleton_06() {
    }

    public static Singleton_06 getInstance() {
        for (; ; ) {
            Singleton_06 instance = INSTANCE.get();
            if (null != instance) return instance;
            INSTANCE.compareAndSet(null, new Singleton_06());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton_06.getInstance()); // top.caibitv.demo.design.Singleton_06@2b193f2d
        System.out.println(Singleton_06.getInstance()); // top.caibitv.demo.design.Singleton_06@2b193f2d
    }
}
