package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ping on 2015/10/8.
 */
public class SourceTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock rlock = rwlock.readLock();
        ReentrantReadWriteLock.WriteLock wlock = rwlock.writeLock();
        synchronized (new Object()) {

        }

        lock.lock();
        lock.unlock();
        rlock.lock();
        rlock.unlock();
        wlock.lock();
        rlock.unlock();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        Proxy.newInstance(SourceTest.class.getClassLoader(), new Integer[], new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        System.arraycopy(null, 0, null, 0, 1);
        Arrays.copyOf(new int[4], 0);
        BlockingQueue bq = new ArrayBlockingQueue(10);
        Queue<String> queue = new LinkedList<>();
        LinkedList<String> q = new LinkedList<>();
        ArrayList list;
        q.poll();
        String str = "";
        str.hashCode();
        LinkedBlockingQueue lq;
        LinkedBlockingDeque ldeque;
        SynchronousQueue sq;


    }
}
