package test.producerAndConsumer2;

/**
 * 消费者类
 *  * create by qiuping.wu on 2015-08-12
 */
public class Consumer implements Runnable {
	private Store store;

	public Consumer(Store store) {
		this.store = store;
	}

	@Override
	public void run() {
		while (true) {
			store.Consume();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
