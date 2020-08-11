package pattern;

import java.util.concurrent.atomic.AtomicReference;

public class SingletonOpt {
	private static final AtomicReference<SingletonOpt> INSTANCE = new AtomicReference<SingletonOpt>();

	private SingletonOpt() {
	}

	public SingletonOpt getInstance() {
		for (;;) {
			SingletonOpt instance = INSTANCE.get();
			if (instance != null) {
				return instance;
			}
			instance = new SingletonOpt();
			if(INSTANCE.compareAndSet(null, instance)) {
				return instance;
			}
		}
	}

}
