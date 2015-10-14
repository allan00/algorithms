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
        // 计算第一行：当背包中没有物品时，总价值为0，这一步可通过dp初始化时默认为0来完成。
        // 计算其他行
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
            return res;// 表示不存在和为s的子集
        // 通过回溯动态规划表，找出和为s的一个子集
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