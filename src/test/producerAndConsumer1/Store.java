package test.producerAndConsumer1;

/**
 * 仓库类
 * create by qiuping.wu on 2015-08-10
 */
public class Store {
	private int count = 0;
	private final int MAX_NUM = 10;

	public void Produce() {
		while (count >= MAX_NUM) {
			System.out.println(Thread.currentThread().getName()+"FFFFFFFFFFFFFFFFFFFFFFFF队列满");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (this) {
			count++;
			System.out.println(Thread.currentThread().getName()+"++++++++++生产者往仓库放入一件商品,count=" + count);
		}
	}

	public void Consume() {
		while (count <= 0) {
			System.out.println(Thread.currentThread().getName()+"00000000000队列空");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		synchronized (this) {
			count--;
			System.out.println(Thread.currentThread().getName()+"---------------消费者取出一件商品,count=" + count);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Store store  = new Store();
		store.Produce();
		store.Produce();
		store.Consume();
		store.Consume();
		store.Consume();
	}

}
