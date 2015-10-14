package nowcoder;

import java.io.File;
import java.net.URL;
import java.sql.DriverManager;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test2
{
    volatile int a;
    public LinkedList<Integer> SubSetSum2(int[] arr, int s) {

        LinkedList<Integer> res = new LinkedList<Integer>();
        if (arr == null || arr.length == 0 || s < 0)
            return res;
        int dp[][] = new int[arr.length+1][s + 1];
        // �����һ�У���������û����Ʒʱ���ܼ�ֵΪ0����һ����ͨ��dp��ʼ��ʱĬ��Ϊ0����ɡ�
        // ����������
        int i,j;
        for (i = 1; i < arr.length+1; i++) {
            for (j = 0; j < s+1; j++) {
                if(j-arr[i-1]>=0){
                    dp[i][j] = Math.max(dp[i-1][j],arr[i-1] + dp[i-1][j-arr[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[arr.length][s]<s)
            return res;// ��ʾ�����ں�Ϊs���Ӽ�
        // ͨ�����ݶ�̬�滮���ҳ���Ϊs��һ���Ӽ�
        i = arr.length;
        j = s;
        while (j >= 0 && i >= 1) {
            if (dp[i][j]>dp[i - 1][j]) {
                res.addFirst(arr[i - 1]);
                j -= arr[i-1];
            }
            i--;
        }
        return res;
    }
    public static void main(String args[]) throws IllegalAccessException, InstantiationException {
        LinkedHashMap map = new LinkedHashMap();
        String s = "";
        Integer i = null;
        Double d = null;
        Date date = null;
        File f = null;
        URL u = null;
        HashMap hashmap = new HashMap();
        ConcurrentHashMap map1 = new ConcurrentHashMap();
        ConcurrentSkipListMap map2;
        AtomicLong al;
        Class clazz = Long.class;
        Long l = (Long)clazz.newInstance();
        ThreadLocal t = new ThreadLocal();
        ExecutorService es = null;
        System.arraycopy(null, 0, null, 0, 0);

        int[] a = new int[10];
        int[] b = a.clone();
        ReentrantLock lock = new ReentrantLock();
        ConcurrentLinkedQueue clq  = new ConcurrentLinkedQueue();
        //Scanner scanner =  new Scanner();
        Thread.interrupted();
        ArrayList list;
        //list.clear();
        System.gc();



    }

}