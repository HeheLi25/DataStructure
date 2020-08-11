package pattern;

import java.util.concurrent.atomic.AtomicReference;


public class SingletonByCAS {
    // CAS 实现 持有 单例实例的引用，CAS 技术保证原子性，AtomicReference 持有引用的变量使用 volatile 修饰保证 可见性 
    private static final AtomicReference<SingletonByCAS> INSTANCE = new AtomicReference<>();

    private SingletonByCAS() {}

    public static SingletonByCAS getInstance() {
        for (;;) {
            /* 单例实现了 直接返回*/
            SingletonByCAS singleton = INSTANCE.get();
            if (singleton != null) {
                return singleton;
            }
            /* 未创建 单例实例，直接 cas 原子创建 */
            singleton = new SingletonByCAS();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
    public static void main(String[] args) {
        SingletonByCAS singletonByLock =SingletonByCAS.getInstance();
        SingletonByCAS singletonByLock1 =SingletonByCAS.getInstance();
        SingletonByCAS singletonByLock2 =SingletonByCAS.getInstance();
        SingletonByCAS singletonByLock3 =SingletonByCAS.getInstance();
        SingletonByCAS singletonByLock4 =SingletonByCAS.getInstance();
        if (singletonByLock == singletonByLock1 && singletonByLock1 == singletonByLock2 && singletonByLock2 == singletonByLock3
                && singletonByLock3 == singletonByLock4){
            System.out.println("Done.");
        }
    }
}