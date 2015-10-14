package test.producerAndConsumer2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 仓库类
 * create by qiuping.wu on 2015-08-12
 */
public class Store<E> {
	private BlockingQueue<E> bq;

	//最大容量呢
	public Store(int max_cap) {
		super();
		bq = new ArrayBlockingQueue<E>(max_cap);
	}

	public void Produce(E product) {
		try {
			bq.put(product);
			System.out.println(Thread.currentThread().getName()+"生产者往仓库放入+++++++++++++++商品:"+product.toString()+",仓库目前大小:" +bq.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public E Consume() {
		try {
			E e = bq.take();
			//System.out.println(Thread.currentThread().getName()+"消费者从仓库取出---------------商品:"+e.toString()+",仓库目前大小:" +bq.size());
			return e;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Store store  = new Store<String>(10);
		store.Produce(1);
		store.Produce(2);
		store.Consume();
		store.Consume();
		store.Consume();
	}

}
