package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import sun.nio.ch.ThreadPool;
import test.producerAndConsumer1.Consumer;
import test.producerAndConsumer1.Store;

public class ProdCons{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server = null;
		try {
			server = new ServerSocket(8888);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*Runnable task = new Consumer(new Store());
		Future f = Executors.newCachedThreadPool().submit(task);*/
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);
		BlockingQueue<String> bq2 = new LinkedBlockingQueue<String>(10);
		Deque<String> dq = new ArrayDeque<String>();
		Deque<String> dq2 = new LinkedBlockingDeque<String>();
		String s = "bba";
		s.compareTo("bbb");
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		HashMap<String,String> hashmap = new HashMap<String,String>();
		ConcurrentHashMap<String , String> chashmap = new ConcurrentHashMap<String, String>();
		Thread t = new Thread(){public void run()
		{
			System.out.println("Hello");
		}};
		ThreadLocal<String> threadlocal = new ThreadLocal<String>();
		ArrayList al =  new ArrayList();
		List l = Collections.synchronizedList(al);
		Properties p = new Properties();
		String str = new String("a");
		
		Integer i1 = new Integer(9);
		System.out.println(i1.equals(9));
		int i = 9;
		System.out.println(i1 instanceof Integer);
		
	}
	public static void main(String args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<String> pq = new PriorityQueue<String>();
		PriorityBlockingQueue<String> pbq = new PriorityBlockingQueue<String>();
		ArrayBlockingQueue abq = new ArrayBlockingQueue(10);
		LinkedBlockingQueue lbq = new LinkedBlockingQueue(10);
		WeakHashMap weakHashMap;
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		ReentrantLock rl = new ReentrantLock();
		rl.unlock();
		ExecutorService es = Executors.newCachedThreadPool();
		ThreadPool pool ;
		
	}

}
