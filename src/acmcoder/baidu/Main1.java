package acmcoder.baidu;


import java.util.Scanner;

/**
 * Created by ping on 2015/9/25.
 */
public class Main1 {

    /*剪枝法*/
    public static long getCount1(long[] A,long t, int c)    {
        long count = 0;
        int n = A.length;

        for(int i=0;i<=n-c;i++) {
            long sum = 0;
            for(int j=i;j<=i+c-1;j++) {
                if(sum>t)   break;
                sum += A[j];
            }
            if(sum <= t)
                count++;
        }
        return count;
    }

    /*动态规划法*/
    public static long getCount2(long[] A,long t, int c)    {
        long count = 0;
        int n = A.length;
        long[] sum = new long[n-c+1];

        for(int i=0;i<=c-1;i++)
            sum[0] += A[i];

        for(int j=1;j<=n-c;j++)
            sum[j] = sum[j-1]-A[j-1]+A[j+c-1];

        for(int i = 0;i<n-c+1;i++)
            if(sum[i]<=t)
                count++;
        return count;
    }
    public static void main(String args[])
    {
        int n;
        long t;
        int c;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        t = s.nextLong();
        c = s.nextInt();
        long[] A = new long[n];
        for(int i=0;i<n;i++)
            A[i] = s.nextLong();
        System.out.println(getCount1(A,t,c));

    }
}
