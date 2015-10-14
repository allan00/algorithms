package test.producerAndConsumer2;

/**
 * 单生产者单消费者测试类
 *  * create by qiuping.wu on 2015-08-12
 */
public class testSingle {

	public static void main(String[] args) {
		Store store  = new Store(10);
		Producer p = new Producer(store);
		Consumer c  = new Consumer(store);
		new Thread(p).start();
		new Thread(c).start();
	}

}
