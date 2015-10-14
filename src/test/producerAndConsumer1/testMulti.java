package test.producerAndConsumer1;

/**
 * 多生产者多消费者测试类
 * create by qiuping.wu on 2015-08-10
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testMulti {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();

		Store store = new Store();
		Producer p = new Producer(store);
		Consumer c = new Consumer(store);

		for (int i = 0; i < 3; i++) {
			es.submit(p);
		}
		for (int i = 0; i < 4; i++) {
			es.submit(c);
		}

	}

}
