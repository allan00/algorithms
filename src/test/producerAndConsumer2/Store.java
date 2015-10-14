package test.producerAndConsumer2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * �ֿ���
 * create by qiuping.wu on 2015-08-12
 */
public class Store<E> {
	private BlockingQueue<E> bq;

	//���������
	public Store(int max_cap) {
		super();
		bq = new ArrayBlockingQueue<E>(max_cap);
	}

	public void Produce(E product) {
		try {
			bq.put(product);
			System.out.println(Thread.currentThread().getName()+"���������ֿ����+++++++++++++++��Ʒ:"+product.toString()+",�ֿ�Ŀǰ��С:" +bq.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public E Consume() {
		try {
			E e = bq.take();
			//System.out.println(Thread.currentThread().getName()+"�����ߴӲֿ�ȡ��---------------��Ʒ:"+e.toString()+",�ֿ�Ŀǰ��С:" +bq.size());
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
