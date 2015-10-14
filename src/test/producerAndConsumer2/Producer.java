package test.producerAndConsumer2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者类
 *  * create by qiuping.wu on 2015-08-12
 */
public class Producer implements Runnable {
private Store store;
private AtomicInteger count = new AtomicInteger(0);
	public Producer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			store.Produce(count.addAndGet(1));
			
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
