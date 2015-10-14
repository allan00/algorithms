package test.producerAndConsumer1;

/**
 * �ֿ���
 * create by qiuping.wu on 2015-08-10
 */
public class Store {
	private int count = 0;
	private final int MAX_NUM = 10;

	public void Produce() {
		while (count >= MAX_NUM) {
			System.out.println(Thread.currentThread().getName()+"FFFFFFFFFFFFFFFFFFFFFFFF������");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (this) {
			count++;
			System.out.println(Thread.currentThread().getName()+"++++++++++���������ֿ����һ����Ʒ,count=" + count);
		}
	}

	public void Consume() {
		while (count <= 0) {
			System.out.println(Thread.currentThread().getName()+"00000000000���п�");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		synchronized (this) {
			count--;
			System.out.println(Thread.currentThread().getName()+"---------------������ȡ��һ����Ʒ,count=" + count);
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
