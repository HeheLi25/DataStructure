package pattern;

import java.util.concurrent.atomic.AtomicReference;


public class SingletonByCAS {
    // CAS ʵ�� ���� ����ʵ�������ã�CAS ������֤ԭ���ԣ�AtomicReference �������õı���ʹ�� volatile ���α�֤ �ɼ��� 
    private static final AtomicReference<SingletonByCAS> INSTANCE = new AtomicReference<>();

    private SingletonByCAS() {}

    public static SingletonByCAS getInstance() {
        for (;;) {
            /* ����ʵ���� ֱ�ӷ���*/
            SingletonByCAS singleton = INSTANCE.get();
            if (singleton != null) {
                return singleton;
            }
            /* δ���� ����ʵ����ֱ�� cas ԭ�Ӵ��� */
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