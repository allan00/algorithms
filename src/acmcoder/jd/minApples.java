package acmcoder.jd;

import java.util.Scanner;

/**
 * Created by ping on 2015/9/19.
 */
public class minApples {
    public static long min(int n)    {
        if(n<=1 || n>9) return -1;
        for(long i=n+1;;i++)
        {
            int count = 0;
            double left = i;
            do  {
                left = (left-1) * (n-1)/n;
                if( isInt(left) )
                    count++;
                if(count == n)
                    return i;
            }
            while( isInt((left-1)/n) && !isZero((left-1)/n) );
        }
    }

    //判断整除后的结果d是否整数
    private static boolean isZero(double d)   {
        return Math.abs(d) < 1e-9;
    }

    //判断整除后的结果d是否整数
    private static boolean isInt(double d)   {
        return Math.abs(d-(int)d) < 1e-9;
    }

    public static void main(String ags[])  {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(min(n));
    }
}
