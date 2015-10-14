package test.producerAndConsumer1;

/**
 * 生产者类
 * create by qiuping.wu on 2015-08-10
 */
public class Producer implements Runnable {
private Store store;
	public Producer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			store.Produce();
			
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
